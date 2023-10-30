package com.GeneradorLecturas.Generador.Publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {
    
    @Autowired
    private RabbitTemplate rt;
    
    @Autowired
    private ObjectMapper om;
    
    @Autowired
    private Queue queue;
    
    public void send(Object mensaje) {
		try {
			String json = om.writeValueAsString(mensaje);
			rt.convertAndSend(queue.getName(), json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
}
