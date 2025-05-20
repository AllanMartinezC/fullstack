package com.example.bilbioteca.duoc.BDD.repository;

import com.example.bilbioteca.duoc.BDD.model.CarritoDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoDeCompraRepository extends JpaRepository<CarritoDeCompra, Long> {

}
