package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Reclamo;
import com.example.bilbioteca.duoc.BDD.services.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reclamos")

public class ReclamoController {

    @Autowired
    private ReclamoService reclamoService;

    @GetMapping
    public List<Reclamo> listar() {
        return reclamoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Reclamo obtener(@PathVariable Long id) {
        return reclamoService.obtenerPorId(id);
    }

    @PostMapping
    public Reclamo crear(@RequestBody Reclamo reclamo) {
        return reclamoService.guardar(reclamo);
    }

    @PutMapping("/{id}")
    public Reclamo actualizar(@PathVariable Long id, @RequestBody Reclamo datos) {
        return reclamoService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reclamoService.eliminar(id);
    }
}
