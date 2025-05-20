package com.example.bilbioteca.duoc.BDD.repository;

import com.example.bilbioteca.duoc.BDD.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByNombre(String nombre);
}
