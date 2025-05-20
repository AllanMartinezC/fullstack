package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "envio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_envio")
    private Long id_envio;

    @Column(name = "origen", nullable = false)
    private String origen;

    @Column(name = "destino", nullable = false)
    private String destino; 

    @Column(name = "estado", nullable = false)
    private String estado; 

    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "logistica_id")
    private Logistica responsable_Logistica;
}
