package com.barberia.controller;

import com.barberia.model.Servicio;
import com.barberia.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // GET /api/servicios — listar todos
    @GetMapping
    public List<Servicio> listar() {
        return servicioService.listarTodos();
    }

    // GET /api/servicios/{id} — buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> buscarPorId(@PathVariable Integer id) {
        return servicioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/servicios — crear nuevo
    @PostMapping
    public Servicio crear(@RequestBody Servicio servicio) {
        return servicioService.guardar(servicio);
    }

    // PUT /api/servicios/{id} — actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizar(@PathVariable Integer id, @RequestBody Servicio servicio) {
        return servicioService.buscarPorId(id).map(existente -> {
            // Aquí copiarías los campos del objeto recibido al existente
            return ResponseEntity.ok(servicioService.guardar(servicio));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/servicios/{id} — eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        servicioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
