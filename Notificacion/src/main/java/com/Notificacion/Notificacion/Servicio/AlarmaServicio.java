package com.Notificacion.Notificacion.Servicio;

import com.Notificacion.Notificacion.Repositorio.AlarmaRepositorio;
import com.Notificacion.Notificacion.Modelo.Alarma;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmaServicio {

    @Autowired
    AlarmaRepositorio ar;

    public List<Alarma> getAll() {
        return ar.findAll();
    }
    
    public Alarma getById(String id){
        return ar.findById(id).get();
    }
    
    public Alarma save(Alarma alarma){
        return ar.save(alarma);
    }
    
    public void delete(String id){
        ar.deleteById(id);
    }

}
