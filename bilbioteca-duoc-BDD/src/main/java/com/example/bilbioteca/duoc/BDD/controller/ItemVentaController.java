package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.ItemVenta;
import com.example.bilbioteca.duoc.BDD.services.ItemVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Item Venta", description = "Operaciones CRUD para Item Venta")
@RestController
@RequestMapping("/itemventa")
public class ItemVentaController {

    @Autowired
    private ItemVentaService itemVentaService;

    @Operation(summary = "Crear un nuevo Item Venta")
    @PostMapping
    public ResponseEntity<ItemVenta> crearItem(@RequestBody ItemVenta itemVenta) {
        ItemVenta nuevoItem = itemVentaService.guardarItem(itemVenta);
        return ResponseEntity.ok(nuevoItem);
    }

    @Operation(summary = "Obtene todos los Item venta")
    @GetMapping
    public ResponseEntity<List<ItemVenta>> obtenerTodosLosItems() {
        List<ItemVenta> items = itemVentaService.obtenerTodos();
        return ResponseEntity.ok(items);
    }

    @Operation(summary = "Eliminar Item Venta por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarItem(@PathVariable Long id) {
    itemVentaService.eliminarItem(id);
    return ResponseEntity.ok("Item de venta eliminado");
}
}
