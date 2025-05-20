package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resena")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena")
    private Long id_resena;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(nullable = false)
    private long calificacion;

    @Column(nullable = false)
    private String comentario;
}
