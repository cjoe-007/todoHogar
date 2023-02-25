package com.market.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.market.model.Client;
import com.market.service.AccesoService;

@CrossOrigin(origins = "*")
@RestController
public class DataController {

	Logger logger = LoggerFactory.getLogger(DataController.class);

	@Autowired
	AccesoService service;

	@GetMapping(value = "listClients", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Client> listClients() {
		return service.listClients();
	}

	@PostMapping(value = "saveClient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> saveClient(@RequestBody Client client) {
		try {
			client.setGroups(client.getGroups().toUpperCase());
			if (service.saveClient(client)) {
				return new ResponseEntity<>("Guardado exitosamente", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No se ha guardado ya que la lista no tiene beneficios disponibles", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "deleteClient/{id}")
	private void eliminarPorId(@PathVariable("id") int idClient) {
		service.deleteClient(idClient);

	}
}
