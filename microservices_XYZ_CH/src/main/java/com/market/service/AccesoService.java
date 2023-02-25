package com.market.service;

import java.util.List;
import java.util.Optional;

import com.market.model.Client;

public interface AccesoService {
	
	List<Client> listClients();
	Boolean saveClient(Client client);
	void deleteClient(int idClient);
	void readXml();
	void readJson();
	Optional<Client> findClient(int idClient);
}
