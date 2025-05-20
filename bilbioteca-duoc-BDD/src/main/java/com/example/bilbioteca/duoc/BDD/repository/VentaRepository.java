package com.example.bilbioteca.duoc.BDD.repository;


import com.example.bilbioteca.duoc.BDD.model.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
