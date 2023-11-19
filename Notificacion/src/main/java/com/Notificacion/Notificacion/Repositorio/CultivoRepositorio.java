package com.Notificacion.Notificacion.Repositorio;

import com.Notificacion.Notificacion.Modelo.Cultivo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultivoRepositorio extends MongoRepository<Cultivo, String> {
}
