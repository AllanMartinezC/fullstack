package com.example.bilbioteca.duoc.BDD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bilbioteca.duoc.BDD.model.Producto;
import com.example.bilbioteca.duoc.BDD.repository.ProductoRepositoryJPA;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepositoryJPA productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizarProducto(int id, Producto nuevoProducto) {
        Optional<Producto> optProducto = productoRepository.findById(id);
        if (optProducto.isPresent()) {
            Producto existente = optProducto.get();
            existente.setNombre(nuevoProducto.getNombre());
            existente.setPrecio(nuevoProducto.getPrecio());
            existente.setStock(nuevoProducto.getStock());
            return productoRepository.save(existente);
        }
        return null;
    }

    public Producto ajustarStock(int id, int cantidad) {
        Optional<Producto> optProducto = productoRepository.findById(id);
        if (optProducto.isPresent()) {
            Producto producto = optProducto.get();
            producto.setStock(producto.getStock() + cantidad);
            return productoRepository.save(producto);
        }
        return null;
    }
}
