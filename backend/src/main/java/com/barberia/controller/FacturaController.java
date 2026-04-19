package com.barberia.controller;

import com.barberia.model.Factura;
import com.barberia.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    // GET /api/facturas — listar todos
    @GetMapping
    public List<Factura> listar() {
        return facturaService.listarTodos();
    }

    // GET /api/facturas/{id} — buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscarPorId(@PathVariable Integer id) {
        return facturaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/facturas — crear nuevo
    @PostMapping
    public Factura crear(@RequestBody Factura factura) {
        return facturaService.guardar(factura);
    }

    // PUT /api/facturas/{id} — actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Integer id, @RequestBody Factura factura) {
        return facturaService.buscarPorId(id).map(existente -> {
            // Aquí copiarías los campos del objeto recibido al existente
            return ResponseEntity.ok(facturaService.guardar(factura));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/facturas/{id} — eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        facturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
