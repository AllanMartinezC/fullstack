package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Resena;
import com.example.bilbioteca.duoc.BDD.services.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Resena", description = "Operaciones CRUD para las Resenas")
@RestController
@RequestMapping("/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @Operation(summary = "Obtener todas las Resenas")
    @GetMapping
    public List<Resena> listar() {
        return resenaService.obtenerTodas();
    }

    @Operation(summary = "Obtener Resena por ID")
    @GetMapping("/{id}")
    public Resena obtener(@PathVariable Long id) {
        return resenaService.obtenerPorId(id);
    }

    @Operation(summary = "Crear una nueva Resena")
    @PostMapping
    public Resena crear(@RequestBody Resena resena) {
        return resenaService.guardar(resena);
    }

    @Operation(summary = "Actualizar Resena por ID")
    @PutMapping("/{id}")
    public Resena actualizar(@PathVariable Long id, @RequestBody Resena datos) {
        return resenaService.actualizar(id, datos);
    }

    @Operation(summary = "Eliminar Resena por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        resenaService.eliminar(id);
    }
}
