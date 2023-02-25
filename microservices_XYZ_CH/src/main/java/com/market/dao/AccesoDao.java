package com.market.dao;

import java.util.List;
import java.util.Optional;

import com.market.model.Client;

public interface AccesoDao {

	List<Client> listClients();
	void saveClient(Client client);
	void deleteClient(int idClient);
	Optional<Client> findClient(int idClient);
}
