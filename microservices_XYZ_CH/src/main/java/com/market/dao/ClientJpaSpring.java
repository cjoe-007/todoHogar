package com.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.model.Client;

public interface ClientJpaSpring extends JpaRepository<Client, Integer> {

}
