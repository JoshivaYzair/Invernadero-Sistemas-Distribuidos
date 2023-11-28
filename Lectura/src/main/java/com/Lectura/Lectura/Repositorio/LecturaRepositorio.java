package com.Lectura.Lectura.Repositorio;

import com.Lectura.Lectura.Modelo.Lectura;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturaRepositorio extends MongoRepository<Lectura, String> {

	List<Lectura> findByIdSensor(String idSensor);
}
