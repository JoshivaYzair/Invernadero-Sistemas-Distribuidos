package com.Lectura.Lectura.Configuracion;

import com.Lectura.Lectura.DTO.LecturaDTO;
import com.Lectura.Lectura.Modelo.Lectura;
import com.Lectura.Lectura.Repositorio.LecturaRepositorio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	final String cola = "generacionLectura";

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private LecturaRepositorio repo;

	@RabbitListener(queues = cola)
	public void recive(@Payload String json) {
		try {
			LecturaDTO lectura = objectMapper.readValue(json, LecturaDTO.class);
			Lectura lec = new Lectura();
			lec.setHumedad(lectura.getHumedad());
			lec.setTemperatura(lectura.getTemperatura());
			lec.setIdSensor(lectura.getIdSensor());
			repo.save(lec);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
