package com.example.bilbioteca.duoc.BDD.repository;

import com.example.bilbioteca.duoc.BDD.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoRepository extends JpaRepository<Reclamo, Long> {
}
