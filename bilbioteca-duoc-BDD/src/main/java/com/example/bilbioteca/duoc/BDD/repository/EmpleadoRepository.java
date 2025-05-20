package com.example.bilbioteca.duoc.BDD.repository;


import com.example.bilbioteca.duoc.BDD.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByRut(String rut);
}
