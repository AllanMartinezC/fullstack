package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "soporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_soporte")
    private Long id_soporte;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
