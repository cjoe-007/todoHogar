package com.tienda.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import inicio.Application;

@AutoConfigureMockMvc
@SpringBootTest(classes = Application.class)
@TestMethodOrder(OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	@Order(0)
	void testRecuperarClientes() throws Exception {
		mock.perform(get("/viewClients")).andDo(print());
	}


	@Test
	@Order(1)
	void testDeleteClient() throws Exception {
		mock.perform(get("/deleteCliente")).andDo(print());
	}
	
	@Test
	@Order(2)
	void testSaveClient() throws Exception{
		mock.perform(post("/saveClient")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"1\",\"email\":\"Prueba\",\"phone\":\"Entrada\",\"group\":\"TH\"}")
				).andDo(print());
	}
}
