package com.market.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name = "client")
@NamedQuery(name="Client.findAll", query="SELECT p FROM Client p")
@Data
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name="email")
	private String email;

	private String phone;
	
	private String benefits;
		
	private String groups;

}