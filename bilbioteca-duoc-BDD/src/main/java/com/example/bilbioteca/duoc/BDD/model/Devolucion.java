package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "devolucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_devolucion")
    private Long id_devolucion;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(nullable = false)
    private int cantidadDevuelta;

    @Column(nullable = false)
    private String motivo;
}
