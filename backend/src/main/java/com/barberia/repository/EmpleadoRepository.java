package com.barberia.repository;

import com.barberia.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    // Spring Data JPA genera automáticamente: findAll, findById, save, deleteById
    // Agrega consultas personalizadas aquí si las necesitas
}
