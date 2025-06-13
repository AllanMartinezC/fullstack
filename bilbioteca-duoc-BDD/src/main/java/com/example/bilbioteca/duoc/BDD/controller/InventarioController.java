package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Inventario;
import com.example.bilbioteca.duoc.BDD.services.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Inventario", description = "Operaciones CRUD para Inventario")
@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Operation(summary = "Obtener todos los Inventarios")
    @GetMapping
    public List<Inventario> obtenerTodos() {
        return inventarioService.obtenerTodosLosInventarios();
    }

    @Operation(summary = "Obtener Inventario por ID de Sucursal")
    @GetMapping("/sucursal/{id}")
    public List<Inventario> obtenerPorSucursal(@PathVariable Long id) {
        return inventarioService.obtenerInventarioPorSucursal(id);
    }

    @Operation(summary = "Agregar Producto a Inventario")
    @PostMapping
    public Inventario agregarProducto(@RequestBody solicitud_inventario body) {
        return inventarioService.agregarProductoAInventario(
            body.idSucursal,
            body.idProducto,
            body.cantidad
        );
    }

    @Operation(summary = "Actualizar Stock de Inventario")
    @PutMapping("/{id}")
    public Inventario actualizarStock(@PathVariable Long id, @RequestParam Long cantidad) {
        return inventarioService.actualizarStock(id, cantidad);
    }

    @Operation(summary = "Eliminar Inventario por ID")
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
