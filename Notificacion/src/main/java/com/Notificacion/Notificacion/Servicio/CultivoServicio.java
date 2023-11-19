package com.Notificacion.Notificacion.Servicio;

import com.Notificacion.Notificacion.DTO.CultivoDTO;
import com.Notificacion.Notificacion.Modelo.Cultivo;
import org.springframework.stereotype.Service;

import com.Notificacion.Notificacion.Repositorio.CultivoRepositorio;
import java.util.List;

@Service
public class CultivoServicio {

    private final CultivoRepositorio cultivoRepositorio;

    public CultivoServicio(CultivoRepositorio cultivoRepositorio) {
        this.cultivoRepositorio = cultivoRepositorio;
    }

    public List<Cultivo> getAll() {
        return cultivoRepositorio.findAll();
    }

    public Cultivo getById(String id) {
        return cultivoRepositorio.findById(id).orElse(null);
    }

    public Cultivo save(CultivoDTO cultivoDTO) {
        Cultivo cultivo = new Cultivo();
        cultivo.setNombre(cultivoDTO.getNombre());
        cultivo.setMaxTemperatura(cultivoDTO.getMaxTemperatura());
        cultivo.setMinTemperatura(cultivoDTO.getMinTemperatura());
        cultivo.setMaxHumedad(cultivoDTO.getMaxHumedad());
        cultivo.setMinHumedad(cultivoDTO.getMinHumedad());
        cultivo.setIdInvernadero(cultivoDTO.getIdInvernadero());
        
        return cultivoRepositorio.save(cultivo);
    }

    public Cultivo update(String id, CultivoDTO cultivoDTO) {
        Cultivo cultivo = cultivoRepositorio.findById(id).orElse(null);
        cultivo.setNombre(cultivoDTO.getNombre());
        cultivo.setMaxTemperatura(cultivoDTO.getMaxTemperatura());
        cultivo.setMinTemperatura(cultivoDTO.getMinTemperatura());
        cultivo.setMaxHumedad(cultivoDTO.getMaxHumedad());
        cultivo.setMinHumedad(cultivoDTO.getMinHumedad());
        cultivo.setIdInvernadero(cultivoDTO.getIdInvernadero());

        return cultivoRepositorio.save(cultivo);
    }

    public void delete(String id) {
        cultivoRepositorio.deleteById(id);
    }
}
