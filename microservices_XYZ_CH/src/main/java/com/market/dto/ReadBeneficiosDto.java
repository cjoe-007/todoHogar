package com.market.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="beneficios")
@XmlAccessorType (XmlAccessType.FIELD)
public class ReadBeneficiosDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> beneficio;
	public List<String> getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(List<String> beneficio) {
		this.beneficio = beneficio;
	}

	
}
