package com.Notificacion.Notificacion.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
public class LecturaDTO {

    private Double temperatura;
    private Double humedad;
    private String invernadero;
}
