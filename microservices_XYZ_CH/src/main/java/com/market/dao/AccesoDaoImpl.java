package com.market.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.market.model.Client;

@Repository
public class AccesoDaoImpl implements AccesoDao {


	@Autowired
	ClientJpaSpring accesClient;

	@Override
	public List<Client> listClients() {
		return accesClient.findAll();
	}
	
	@Override
	public void saveClient(Client client) {
		accesClient.save(client);
	}
	
	@Override
	public void deleteClient(int idClient) {
		accesClient.deleteById(idClient);
	}

	@Override
	public Optional<Client> findClient(int idClient) {
		return accesClient.findById(idClient);
	}

}
