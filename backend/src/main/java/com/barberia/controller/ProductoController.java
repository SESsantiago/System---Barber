package com.barberia.controller;

import com.barberia.model.Producto;
import com.barberia.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // GET /api/productos — listar todos
    @GetMapping
    public List<Producto> listar() {
        return productoService.listarTodos();
    }

    // GET /api/productos/{id} — buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id) {
        return productoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/productos — crear nuevo
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }

    // PUT /api/productos/{id} — actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.buscarPorId(id).map(existente -> {
            // Aquí copiarías los campos del objeto recibido al existente
            return ResponseEntity.ok(productoService.guardar(producto));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/productos/{id} — eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
