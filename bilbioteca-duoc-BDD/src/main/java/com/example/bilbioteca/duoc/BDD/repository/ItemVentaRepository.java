package com.example.bilbioteca.duoc.BDD.repository;

import com.example.bilbioteca.duoc.BDD.model.ItemVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVentaRepository extends JpaRepository<ItemVenta, Long> {
}

