package com.jaime.practica4_api_rest.controllers;

import com.jaime.practica4_api_rest.models.Accion;
import com.jaime.practica4_api_rest.repositories.AccionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acciones")
public class AccionController {

    private final AccionRepository repo;

    public AccionController(AccionRepository repo) {
        this.repo = repo;
    }

    // CREATE (POST)
    @PostMapping
    public ResponseEntity<Accion> crearAccion(@RequestBody Accion accion) {
        Accion nueva = repo.save(accion);
        return ResponseEntity.ok(nueva);
    }

    // READ ALL (GET)
    @GetMapping
    public List<Accion> obtenerTodas() {
        return repo.findAll();
    }

    // READ ONE (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Accion> obtenerUna(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Accion> actualizarAccion(@PathVariable Long id,
                                                   @RequestBody Accion accionActualizada) {
        return repo.findById(id).map(accion -> {
            accion.setFecha(accionActualizada.getFecha());
            accion.setPrecioCierre(accionActualizada.getPrecioCierre());
            accion.setVolumen(accionActualizada.getVolumen());
            repo.save(accion);
            return ResponseEntity.ok(accion);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE (IF-ELSE para evitar problemas de tipos)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAccion(@PathVariable Long id) {
        Optional<Accion> encontrado = repo.findById(id);
        if (encontrado.isPresent()) {
            repo.delete(encontrado.get());
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build();   // 404
        }
    }
}
