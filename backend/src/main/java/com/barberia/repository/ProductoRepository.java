package com.barberia.repository;

import com.barberia.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Spring Data JPA genera automáticamente: findAll, findById, save, deleteById
    // Agrega consultas personalizadas aquí si las necesitas
}
