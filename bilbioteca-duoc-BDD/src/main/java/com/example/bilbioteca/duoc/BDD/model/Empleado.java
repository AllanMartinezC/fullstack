package com.example.bilbioteca.duoc.BDD.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_empleado")
@Entity
@Table(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id_empleado;

    @Column(name = "rut", nullable = false, unique = true)
    private String rut;

    @Column(name = "digito_verificador", length = 1, nullable = false)
    private String digitoVerificador;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cargo")
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    @JsonIgnoreProperties({"direccion", "horarioApertura", "horarioCierre", "politicasLocales", "empleados", "gerente"})
    private Sucursal sucursal;
}
