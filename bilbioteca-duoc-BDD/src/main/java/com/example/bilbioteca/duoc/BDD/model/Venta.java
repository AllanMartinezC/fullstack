package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id_venta;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha = LocalDate.now();

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Usuario cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ItemVenta> items;
}
