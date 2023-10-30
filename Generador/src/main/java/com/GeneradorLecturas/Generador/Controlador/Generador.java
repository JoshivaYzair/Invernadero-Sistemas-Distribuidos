package com.GeneradorLecturas.Generador.Controlador;

import com.GeneradorLecturas.Generador.DTO.LecturaDTO;
import com.GeneradorLecturas.Generador.Publisher.Publisher;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class Generador {

    @Autowired
    private Publisher publisher;

    @Scheduled(fixedDelay = 10000)
    public void generarDatos() {
        // Generar datos de temperatura y humedad emulados
        double temperatura = ThreadLocalRandom.current().nextDouble(10, 60);
        double humedad = ThreadLocalRandom.current().nextDouble(5, 50);
        String invernadero = "invernadero no.1";
        // Enviar los datos 
        LecturaDTO lecturaDto = new LecturaDTO();
        lecturaDto.setTemperatura(temperatura);
        lecturaDto.setHumedad(humedad);
        lecturaDto.setInvernadero(invernadero);
        publisher.send(lecturaDto);
    }

}
