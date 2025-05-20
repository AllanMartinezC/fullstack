package com.example.bilbioteca.duoc.BDD.repository;

import com.example.bilbioteca.duoc.BDD.model.CuponDescuento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuponDescuentoRepository extends JpaRepository<CuponDescuento, Long> {
    Optional<CuponDescuento> findByCodigo(String codigo);
}
