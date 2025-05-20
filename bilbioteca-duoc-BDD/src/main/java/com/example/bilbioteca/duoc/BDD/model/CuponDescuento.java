package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "cupon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuponDescuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cupon")
    private Long id_cupon;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column(nullable = false)
    private double porcentaje;

    @Column(nullable = false)
    private boolean activo;
}
