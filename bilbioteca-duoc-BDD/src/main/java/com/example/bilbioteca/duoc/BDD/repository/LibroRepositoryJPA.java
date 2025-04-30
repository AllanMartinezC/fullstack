package com.example.bilbioteca.duoc.BDD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bilbioteca.duoc.BDD.model.Libro;
import java.util.List;


public interface LibroRepositoryJPA extends JpaRepository<Libro, Long>{

    Libro findById(int id);

    void deleteById(int id);
}
