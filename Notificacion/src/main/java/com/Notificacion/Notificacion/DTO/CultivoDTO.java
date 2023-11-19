package com.Notificacion.Notificacion.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CultivoDTO {

    private String nombre;
    private int maxTemperatura;
    private int minTemperatura;
    private int maxHumedad;
    private int minHumedad;
    private String idInvernadero;
}
