package com.barberia.controller;

import com.barberia.model.Cita;
import com.barberia.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    // GET /api/citas — listar todos
    @GetMapping
    public List<Cita> listar() {
        return citaService.listarTodos();
    }

    // GET /api/citas/{id} — buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscarPorId(@PathVariable Integer id) {
        return citaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/citas — crear nuevo
    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return citaService.guardar(cita);
    }

    // PUT /api/citas/{id} — actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizar(@PathVariable Integer id, @RequestBody Cita cita) {
        return citaService.buscarPorId(id).map(existente -> {
            // Aquí copiarías los campos del objeto recibido al existente
            return ResponseEntity.ok(citaService.guardar(cita));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/citas/{id} — eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
