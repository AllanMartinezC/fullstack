package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.CarritoDeCompra;
import com.example.bilbioteca.duoc.BDD.services.CarritoDeCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoDeCompraController {

    @Autowired
    private CarritoDeCompraService carritoDeCompraService;

    @PostMapping
    public CarritoDeCompra crear(@RequestBody CarritoDeCompra carrito) {
        return carritoDeCompraService.guardarCarrito(carrito);
    }

    @GetMapping
    public List<CarritoDeCompra> obtenerTodos() {
        return carritoDeCompraService.listarCarritos();
    }

    @GetMapping("/{id}")
    public CarritoDeCompra obtenerPorId(@PathVariable Long id) {
        return carritoDeCompraService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        carritoDeCompraService.eliminarCarrito(id);
    }
}
