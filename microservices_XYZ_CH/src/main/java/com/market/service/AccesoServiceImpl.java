package com.market.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.dao.AccesoDao;
import com.market.dto.ReadJsonDto;
import com.market.dto.ReadXMLDto;
import com.market.model.Client;

/**
 * @author Jose
 *
 */
@Service
public class AccesoServiceImpl implements AccesoService {
	
	Logger logger = LoggerFactory.getLogger(AccesoServiceImpl.class);
	
	List<String> valuesXML;
	List<String> valuesJSON;

	@Autowired
	AccesoDao dao;
	
	public AccesoServiceImpl() {
		readXml();
		readJson();
	}

	@Override
	public List<Client> listClients() {
		return dao.listClients();
	}

	public Boolean saveClient(Client client) {
		 if (validateGroup(client)) {
			 dao.saveClient(client);
			 return true;
		 }
		 return false;
	}

	public void deleteClient(int idClient) {

		Optional<Client> client = findClient(idClient);
		if (client.get().getGroups().equals("TH")) {
			valuesXML.add(client.get().getBenefits());
		} else {
			valuesJSON.add(client.get().getBenefits());
		}

		dao.deleteClient(idClient);
	}

	public Optional<Client> findClient(int idClient) {
		return dao.findClient(idClient);
	}

	/**
	 * Lee un archivo xml via http
	 */
	public void readXml() {
		ReadXMLDto readXml = null;
		
		try {
			URL url = new URL(
					"https://raw.githubusercontent.com/SistemasComoHogar/ClientesBack/672769a2acf64c8be46b373eba54a0bc63cf033c/Referencias/th_formato.xml");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String entrada;
			String cadena = "";
			while ((entrada = br.readLine()) != null) {
				cadena = cadena + entrada;
			}
			JAXBContext contextSession = JAXBContext.newInstance(ReadXMLDto.class);
			Unmarshaller unSession = contextSession.createUnmarshaller();
			StringReader readerResult = new StringReader(cadena);
			readXml = (ReadXMLDto) unSession.unmarshal(readerResult);
			List<List<String>> valoresList = readXml.getBeneficios().stream().map(t-> t.getBeneficio()).collect(Collectors.toList());
			valuesXML = valoresList.get(0);
		} catch (Exception ex) {
			logger.info(ex.toString());
		}
	}

	/**
	 * Lee un archivo xml via http
	 */
	public void readJson() {
		String url = "https://raw.githubusercontent.com/SistemasComoHogar/ClientesBack/672769a2acf64c8be46b373eba54a0bc63cf033c/Referencias/sk_formato.json";
		try {
			// Crear una conexión HTTP con la URL
			HttpURLConnection conexion = (HttpURLConnection) new URL(url).openConnection();

			// Establecer el método de solicitud
			conexion.setRequestMethod("GET");

			// Obtener la response HTTP
			int codigoresponse = conexion.getResponseCode();

			if (codigoresponse == HttpURLConnection.HTTP_OK) {
				// Leer la response JSON
				BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				String linea;
				StringBuilder response = new StringBuilder();
				while ((linea = lector.readLine()) != null) {
					response.append(linea);
				}
				lector.close();

				// Convertir la response JSON a un objeto Java
				ObjectMapper mapper = new ObjectMapper();
				ReadJsonDto objeto = mapper.readValue(response.toString(), ReadJsonDto.class);

				// Utilizar el objeto Java para procesar la información del archivo JSON
				// Cerrar la conexión HTTP
				conexion.disconnect();
				valuesJSON = objeto.getSk_formato().stream().map(t-> t.getBeneficio()).collect(Collectors.toList());
			}
		} catch (Exception ex) {
			logger.info("Error al leer el archivo JSON. Código de response HTTP: " + ex);
		}
	}

	/**
	 * Valida el grupo y el tipo de benefits para poder guardar
	 * 
	 * @param client
	 */
	public Boolean validateGroup(Client client) {
		
		if (client.getGroups().equals("TH")) {
			
			if (valuesXML.size() > 0) {				 
				client.setBenefits(randomList(valuesXML));
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}

		} else {
			if (valuesJSON.size() > 0) {				 
				client.setBenefits(randomList(valuesJSON));
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		}
	}
	
	public String randomList(List<String> list) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(list.size());
		String randomElement = list.get(randomIndex);
		list.remove(randomIndex);
		return randomElement;
	}
}
