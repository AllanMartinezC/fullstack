package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Producto;
import com.example.bilbioteca.duoc.BDD.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private ProductoServices productoService;

    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.getProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        return productoService.actualizarProducto(id, nuevoProducto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/{id}/stock")
    public Producto ajustarStock(@PathVariable Long id, @RequestParam Long cantidad) {
        return productoService.ajustarStock(id, cantidad);
    }
}
