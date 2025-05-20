package com.example.bilbioteca.duoc.BDD.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_sucursal")
@Entity
@Table(name = "Sucursal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long id_sucursal;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "horario_apertura")
    private String horarioApertura;

    @Column(name = "horario_cierre")
    private String horarioCierre;

    @Column(name = "politicas_locales")
    private String politicasLocales;

    @OneToMany(mappedBy = "sucursal")
    private List<Empleado> empleados;

    @ManyToOne
    @JoinColumn(name = "id_gerente")
    private Gerente gerente;
}

    

