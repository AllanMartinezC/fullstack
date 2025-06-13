package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Producto;
import com.example.bilbioteca.duoc.BDD.services.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Producto", description = "Operaciones CRUD para Producto")
@RestController
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private ProductoServices productoService;

    @Operation(summary = "Obtener todos los Productos")
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.getProductos();
    }

    @Operation(summary = "Obtener Producto por ID")
    @GetMapping("/{id}")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @Operation(summary = "Agregar un nuevo Prodcuto")
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @Operation(summary = "Actualizar Producto por ID")
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto nuevoProducto) {
        return productoService.actualizarProducto(id, nuevoProducto);
    }

    @Operation(summary = "Eliminar Producto por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }

    @Operation(summary = "Actualizar Producto en Stock")
    @PutMapping("/{id}/stock")
    public Producto ajustarStock(@PathVariable Long id, @RequestParam Long cantidad) {
        return productoService.ajustarStock(id, cantidad);
    }
}
