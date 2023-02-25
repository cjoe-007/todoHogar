package com.market.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="th_formato")
@XmlAccessorType (XmlAccessType.FIELD)
public class ReadXMLDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="beneficios")
	private List<ReadBeneficiosDto> beneficios;

	public List<ReadBeneficiosDto> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<ReadBeneficiosDto> beneficios) {
		this.beneficios = beneficios;
	}
	
}
