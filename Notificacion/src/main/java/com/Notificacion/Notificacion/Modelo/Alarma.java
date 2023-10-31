package com.Notificacion.Notificacion.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document(collection="notificaciones")
public class Alarma {
    
    @Id
    private String id;
    private float temMax;
    private float temMin;
    private float humMax;
    private float humMin;
    private String invernadero;
}
