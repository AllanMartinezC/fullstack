package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reclamacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reclamacion")
    private Long id_reclamo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(nullable = false)
    private String descripcion;

}
