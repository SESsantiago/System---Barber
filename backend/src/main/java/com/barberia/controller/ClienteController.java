package com.barberia.controller;

import com.barberia.model.Cliente;
import com.barberia.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // GET /api/clientes — listar todos
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    // GET /api/clientes/{id} — buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/clientes — crear nuevo
    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    // PUT /api/clientes/{id} — actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return clienteService.buscarPorId(id).map(existente -> {
            // Aquí copiarías los campos del objeto recibido al existente
            return ResponseEntity.ok(clienteService.guardar(cliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/clientes/{id} — eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
