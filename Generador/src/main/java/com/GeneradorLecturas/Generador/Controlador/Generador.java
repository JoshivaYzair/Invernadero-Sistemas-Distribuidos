package com.GeneradorLecturas.Generador.Controlador;

import com.GeneradorLecturas.Generador.DTO.LecturaDTO;
import com.GeneradorLecturas.Generador.Publisher.Publisher;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class Generador {

    @Autowired
    private Publisher publisher;

    @Scheduled(fixedDelay = 10000)
    public void generarDatos() {
        List<String> invernaderos = new ArrayList<>();
        invernaderos.add("invernadero no.1");
        invernaderos.add("invernadero no.2");
        invernaderos.add("invernadero no.3");
        invernaderos.add("invernadero no.4");
        
        // Generar datos de temperatura y humedad emulados
        Random random = new Random();
        int indiceAleatorio = random.nextInt(invernaderos.size());
        
        double temperatura = random.nextInt(61);
        double humedad = random.nextInt(51);
        String invernadero = invernaderos.get(indiceAleatorio);
        
        // Enviar los datos 
        LecturaDTO lecturaDto = new LecturaDTO();
        lecturaDto.setTemperatura(temperatura);
        lecturaDto.setHumedad(humedad);
        lecturaDto.setInvernadero(invernadero);
        System.out.println(lecturaDto.toString());
        publisher.send(lecturaDto);
    }

}
