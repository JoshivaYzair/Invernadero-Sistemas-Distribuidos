package com.Notificacion.Notificacion.Controlador;

import com.Notificacion.Notificacion.Servicio.AlarmaServicio;
import com.Notificacion.Notificacion.Modelo.Alarma;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionControlador {
    
    @Autowired
    private AlarmaServicio as;
    
    @GetMapping
    public ResponseEntity<List<Alarma>> getAll(){
        List <Alarma> alarmas= as.getAll();
        if (alarmas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(alarmas);
    }
    
    @PostMapping
    public ResponseEntity<Alarma> save(@RequestBody Alarma alarma){
        Alarma ala = as.save(alarma);
        return ResponseEntity.ok(ala);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") String id) {
        as.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
