package com.Lectura.Lectura.Servicio;

import com.Lectura.Lectura.Modelo.Lectura;
import com.Lectura.Lectura.Repositorio.LecturaRepositorio;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LecturaServicio {

	@Autowired
	private LecturaRepositorio repo;

	public List<Lectura> getAll() {
		return repo.findAll();
	}

	public Lectura getLecturaById(String id) {
		return repo.findById(id).orElse(null);
	}

	public Lectura save(Lectura lec) {
		Lectura newLec = repo.save(lec);
		return newLec;
	}

	public List<Lectura> getTen() {
		List<Lectura> todasLasLecturas = repo.findAll();

		int totalLecturas = todasLasLecturas.size();
		int inicio = Math.max(0, totalLecturas - 10); 

		return todasLasLecturas.stream()
		.skip(inicio)
		.collect(Collectors.toList());
	}

	public List<Lectura> getBySenId(String senId) {
		return repo.findByIdSensor(senId);
	}
}
