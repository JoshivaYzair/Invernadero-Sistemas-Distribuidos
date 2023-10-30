
package com.Notificacion.Notificacion.Consumidor;

import com.Notificacion.Notificacion.DTO.LecturaDTO;
import com.Notificacion.Notificacion.Modelo.Alarma;
import com.Notificacion.Notificacion.Servicio.AlarmaServicio;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    
    private final String cola = "generacionLectura";
    
    @Autowired
    private ObjectMapper om;
    
    @Autowired AlarmaServicio as;
    
    
    @RabbitListener(queues = cola)
    public void recive(@Payload String json){
        
        try {
            LecturaDTO lecturadto = om.readValue(json, LecturaDTO.class);
            List<Alarma> lista = as.getAll();
            for (Alarma al:lista) {
                if (lecturadto.getInvernadero().equalsIgnoreCase(al.getInvernadero())) {
                    if (lecturadto.getHumedad()>al.getHumMax() || lecturadto.getHumedad() < al.getHumMin()) {
                        System.out.println("======[ALERTA]======");
                        System.out.println("Humedad limite maxima: "+ al.getHumMax());
                        System.out.println("Humedad limite minima:"+ al.getHumMin());
                        System.out.println("Humedad actual: " + lecturadto.getHumedad());
                    }
                    if (lecturadto.getTemperatura()> al.getTemMax() || lecturadto.getTemperatura() < al.getTemMin()) {
                        System.out.println("======[ALERTA]======");
                        System.out.println("Temperatura limite maxima: "+ al.getTemMax());
                        System.out.println("Temperatura limite minima:"+ al.getTemMin());
                        System.out.println("Temperatura actual: " + lecturadto.getTemperatura());
                    }
                }
            }
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
