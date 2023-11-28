package com.Notificacion.Notificacion.Repositorio;

import com.Notificacion.Notificacion.Modelo.Alarma;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmaRepositorio extends MongoRepository<Alarma, String>{
    
}
