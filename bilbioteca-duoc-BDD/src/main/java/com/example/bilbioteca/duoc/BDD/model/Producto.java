package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private int id_producto;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, length = 50)
    private int precio;
    @Column(nullable = false)
    private int stock;
}
