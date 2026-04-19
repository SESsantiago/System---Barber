package com.barberia.repository;

import com.barberia.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    // Spring Data JPA genera automáticamente: findAll, findById, save, deleteById
    // Agrega consultas personalizadas aquí si las necesitas
}
