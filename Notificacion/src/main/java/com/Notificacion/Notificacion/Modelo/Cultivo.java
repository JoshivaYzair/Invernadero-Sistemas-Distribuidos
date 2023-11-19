package com.Notificacion.Notificacion.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class Cultivo {
    @Id
    private String id;
    private String nombre;
    private int maxTemperatura;
    private int minTemperatura;
    private int maxHumedad;
    private int minHumedad;
    private String idInvernadero;
}
