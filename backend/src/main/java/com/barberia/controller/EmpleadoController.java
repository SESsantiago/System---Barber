package com.barberia.controller;

import com.barberia.model.Empleado;
import com.barberia.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@CrossOrigin(origins = "*")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // GET /api/empleados — listar todos
    @GetMapping
    public List<Empleado> listar() {
        return empleadoService.listarTodos();
    }

    // GET /api/empleados/{id} — buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarPorId(@PathVariable Integer id) {
        return empleadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/empleados — crear nuevo
    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoService.guardar(empleado);
    }

    // PUT /api/empleados/{id} — actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Integer id, @RequestBody Empleado empleado) {
        return empleadoService.buscarPorId(id).map(existente -> {
            // Aquí copiarías los campos del objeto recibido al existente
            return ResponseEntity.ok(empleadoService.guardar(empleado));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/empleados/{id} — eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
