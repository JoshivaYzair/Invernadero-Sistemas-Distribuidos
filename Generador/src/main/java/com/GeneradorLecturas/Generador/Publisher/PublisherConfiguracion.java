package com.GeneradorLecturas.Generador.Publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfiguracion {
    
	private final String cola = "generacionLectura";
	
	@Bean
	public Queue queue() {
		return new Queue(cola,true);
	}
}
