package com.example.bilbioteca.duoc.BDD.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bilbioteca.duoc.BDD.model.Producto;
import com.example.bilbioteca.duoc.BDD.repository.ProductoRepositoryJPA;

@Service
public class ProductoServices {

    @Autowired
    private ProductoRepositoryJPA productoRepositoryJPA;

    public List<Producto> getProductos() {
        return productoRepositoryJPA.findAll();
    }

    public Producto getProductoById(Long id) {
        return productoRepositoryJPA.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepositoryJPA.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepositoryJPA.deleteById(id);
    }

    public Producto actualizarProducto(Long id, Producto nuevo_Producto) {
        Producto producto_Actual = productoRepositoryJPA.findById(id).orElse(null);
        if (producto_Actual == null) {
            return null;
        }
        producto_Actual.setNombre(nuevo_Producto.getNombre());
        producto_Actual.setPrecio(nuevo_Producto.getPrecio());
        producto_Actual.setStock(nuevo_Producto.getStock());
        return productoRepositoryJPA.save(producto_Actual);
    }

    public Producto ajustarStock(Long id, Long cantidad) {
        Producto producto = productoRepositoryJPA.findById(id).orElse(null);
        if (producto == null) {
            return null;
        }
        producto.setStock(producto.getStock() + cantidad);
        return productoRepositoryJPA.save(producto);
    }
}
