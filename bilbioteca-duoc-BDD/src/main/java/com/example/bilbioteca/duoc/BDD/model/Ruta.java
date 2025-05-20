package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ruta_entrega")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ruta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruta")
    private Long id_ruta;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(name = "prioridad")
    private String prioridad; 

    @OneToOne
    @JoinColumn(name = "envio_id")
    private Envio envio;
}
