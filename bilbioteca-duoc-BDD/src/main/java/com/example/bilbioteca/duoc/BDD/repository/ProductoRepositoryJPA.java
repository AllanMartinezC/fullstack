package com.example.bilbioteca.duoc.BDD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bilbioteca.duoc.BDD.model.Producto;

@Repository
public interface ProductoRepositoryJPA extends JpaRepository<Producto, Integer> {

    Producto findById(int id);

    void deleteById(int id);
}
