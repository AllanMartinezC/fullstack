package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.ItemCarrito;
import com.example.bilbioteca.duoc.BDD.services.ItemCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Item Carrito", description = "Operaciones CRUD para Item Carrito")
@RestController
@RequestMapping("/item-carrito")
public class ItemCarritoController {

    @Autowired
    private ItemCarritoService itemCarritoService;

    @Operation(summary = "Guardar un Item en Item Carrito")
    @PostMapping("/guardar")
    public ItemCarrito guardarItem(@RequestBody ItemCarrito item) {
        return itemCarritoService.guardarItem(item);
    }

    @Operation(summary = "Obtener todos los Items del Item Carrito")
    @GetMapping("/listar")
    public List<ItemCarrito> listarItems() {
        return itemCarritoService.listarItems();
    }

    @Operation(summary = "Buscar un Item por ID")
    @GetMapping("/buscar/{id}")
    public ItemCarrito buscarPorId(@PathVariable Long id) {
        return itemCarritoService.buscarPorId(id);
    }

    @Operation(summary = "Eliminar Item por ID")
    @DeleteMapping("/eliminar/{id}")
    public void eliminarItem(@PathVariable Long id) {
        itemCarritoService.eliminarItem(id);
    }
}
