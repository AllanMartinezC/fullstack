package com.example.bilbioteca.duoc.BDD.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bilbioteca.duoc.BDD.model.Producto;

@Repository
public interface ProductoRepositoryJPA extends JpaRepository<Producto, Long> {

    Optional<Producto> findById(Long id);

    void deleteById(Long id);
}
