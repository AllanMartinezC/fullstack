package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.ItemCarrito;
import com.example.bilbioteca.duoc.BDD.services.ItemCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-carrito")
public class ItemCarritoController {

    @Autowired
    private ItemCarritoService itemCarritoService;

    @PostMapping("/guardar")
    public ItemCarrito guardarItem(@RequestBody ItemCarrito item) {
        return itemCarritoService.guardarItem(item);
    }

    @GetMapping("/listar")
    public List<ItemCarrito> listarItems() {
        return itemCarritoService.listarItems();
    }

    @GetMapping("/buscar/{id}")
    public ItemCarrito buscarPorId(@PathVariable Long id) {
        return itemCarritoService.buscarPorId(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarItem(@PathVariable Long id) {
        itemCarritoService.eliminarItem(id);
    }
}
