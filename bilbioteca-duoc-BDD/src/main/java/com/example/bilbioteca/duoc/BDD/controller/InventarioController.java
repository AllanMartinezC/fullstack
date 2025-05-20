package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Inventario;
import com.example.bilbioteca.duoc.BDD.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> obtenerTodos() {
        return inventarioService.obtenerTodosLosInventarios();
    }

    @GetMapping("/sucursal/{id}")
    public List<Inventario> obtenerPorSucursal(@PathVariable Long id) {
        return inventarioService.obtenerInventarioPorSucursal(id);
    }

    @PostMapping
    public Inventario agregarProducto(@RequestBody solicitud_inventario body) {
        return inventarioService.agregarProductoAInventario(
            body.idSucursal,
            body.idProducto,
            body.cantidad
        );
    }

    @PutMapping("/{id}")
    public Inventario actualizarStock(@PathVariable Long id, @RequestParam Long cantidad) {
        return inventarioService.actualizarStock(id, cantidad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventarioService.eliminarDelInventario(id);
    }

    static class solicitud_inventario {
        public Long idSucursal;
        public Long idProducto;
        public Long cantidad;
    }
}
