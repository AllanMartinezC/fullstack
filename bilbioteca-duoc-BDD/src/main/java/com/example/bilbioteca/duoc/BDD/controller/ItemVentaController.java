package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.ItemVenta;
import com.example.bilbioteca.duoc.BDD.services.ItemVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemventa")
public class ItemVentaController {

    @Autowired
    private ItemVentaService itemVentaService;

    @PostMapping
    public ResponseEntity<ItemVenta> crearItem(@RequestBody ItemVenta itemVenta) {
        ItemVenta nuevoItem = itemVentaService.guardarItem(itemVenta);
        return ResponseEntity.ok(nuevoItem);
    }

    @GetMapping
    public ResponseEntity<List<ItemVenta>> obtenerTodosLosItems() {
        List<ItemVenta> items = itemVentaService.obtenerTodos();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarItem(@PathVariable Long id) {
    itemVentaService.eliminarItem(id);
    return ResponseEntity.ok("Item de venta eliminado");
}
}
