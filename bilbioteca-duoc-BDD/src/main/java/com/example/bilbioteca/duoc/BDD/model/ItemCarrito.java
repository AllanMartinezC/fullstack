package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_carrito")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id_item;

    @ManyToOne
    @JoinColumn(name = "carrito_id")
    private CarritoDeCompra carrito;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    public void setPrecioUnitarioDesdeProducto() {
        if (this.producto != null) {
            this.precioUnitario = this.producto.getPrecio();
        }
    }
}
