package com.Notificacion.Notificacion.Controlador;

import com.Notificacion.Notificacion.DTO.CultivoDTO;
import com.Notificacion.Notificacion.Modelo.Cultivo;
import com.Notificacion.Notificacion.Servicio.CultivoServicio;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cultivos")
public class CultivoControlador {

    private final CultivoServicio cultivoServicio;

    public CultivoControlador(CultivoServicio cultivoServicio) {
        this.cultivoServicio = cultivoServicio;
    }

    @GetMapping
    public ResponseEntity<List<Cultivo>> getAll() {
        return ResponseEntity.ok(cultivoServicio.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cultivo> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(cultivoServicio.getById(id));
    }
    
    @PostMapping
    public ResponseEntity<Cultivo> save(@RequestBody CultivoDTO cultivoDTO){
        return ResponseEntity.ok(cultivoServicio.save(cultivoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cultivo> update(@PathVariable("id") String id, @RequestBody CultivoDTO cultivoDTO) {
        return ResponseEntity.ok(cultivoServicio.update(id, cultivoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        cultivoServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}
