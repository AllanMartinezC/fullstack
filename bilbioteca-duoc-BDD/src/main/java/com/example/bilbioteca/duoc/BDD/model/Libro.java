package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    private int id;
    @Column(nullable = false)
    private String isbn;
    @Column(nullable = false, length = 50)
    private String titulo;
    @Column(nullable = false)
    private String editorial;
    @Column(nullable = false)
    private int fechaPublicacion;
    @Column(nullable = false)
    private String autor;
}
