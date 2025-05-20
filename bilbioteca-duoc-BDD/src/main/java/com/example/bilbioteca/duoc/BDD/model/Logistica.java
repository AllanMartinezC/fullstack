package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "logistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logistica")
    private Long id_logistica;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String rut;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;
}


