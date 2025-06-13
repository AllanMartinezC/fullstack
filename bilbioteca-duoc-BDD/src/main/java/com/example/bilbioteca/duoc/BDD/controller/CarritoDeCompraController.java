package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.CarritoDeCompra;
import com.example.bilbioteca.duoc.BDD.services.CarritoDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Carrito De Compra", description = "Operaciones CRUD para el Carrito de Compra")
@RestController
@RequestMapping("/carrito")
public class CarritoDeCompraController {

    @Autowired
    private CarritoDeCompraService carritoDeCompraService;

    @Operation(summary = "Crear un nuevo carrito de compra")
    @PostMapping
    public CarritoDeCompra crear(@RequestBody CarritoDeCompra carrito) {
        return carritoDeCompraService.guardarCarrito(carrito);
    }

    @Operation(summary = "Obtener todos los carritos")
    @GetMapping
    public List<CarritoDeCompra> obtenerTodos() {
        return carritoDeCompraService.listarCarritos();
    }

    @Operation(summary = "Obtener carrito por ID")
    @GetMapping("/{id}")
    public CarritoDeCompra obtenerPorId(@PathVariable Long id) {
        return carritoDeCompraService.buscarPorId(id);
    }

    @Operation(summary = "Eliminar carrito por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        carritoDeCompraService.eliminarCarrito(id);
    }
}
