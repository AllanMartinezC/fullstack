package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Reclamo;
import com.example.bilbioteca.duoc.BDD.services.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Reclamo", description = "Operaciones CRUD para Reclamo")
@RestController
@RequestMapping("/reclamos")

public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @Operation(summary = "Obtener todos los Reclamos")
    @GetMapping
    public List<Reclamo> listar() {
        return reclamoService.obtenerTodos();
    }

    @Operation(summary = "Obtener Reclamo por ID")
    @GetMapping("/{id}")
    public Reclamo obtener(@PathVariable Long id) {
        return reclamoService.obtenerPorId(id);
    }

    @Operation(summary = "Crear un nuevo Reclamo")
    @PostMapping
    public Reclamo crear(@RequestBody Reclamo reclamo) {
        return reclamoService.guardar(reclamo);
    }

    @Operation(summary = "Actualizar Reclamo por ID")
    @PutMapping("/{id}")
    public Reclamo actualizar(@PathVariable Long id, @RequestBody Reclamo datos) {
        return reclamoService.actualizar(id, datos);
    }

    @Operation(summary = "Eliminar Reclamo por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reclamoService.eliminar(id);
    }
}
