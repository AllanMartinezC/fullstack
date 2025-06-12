package com.example.bilbioteca.duoc.BDD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bilbioteca.duoc.BDD.model.Soporte;
import com.example.bilbioteca.duoc.BDD.services.SoporteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Soporte", description = "Operaciones CRUD para Soporte")
@RestController
@RequestMapping("/soporte")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    
    @Operation(summary = "Obtener todos los trabajadores de soporte")
    @GetMapping
    public List<Soporte> listar() {
        return soporteService.obtenerTodos();
    }

    @Operation(summary = "Obtener todos los trabajadores mediante id")
    @GetMapping("/{id}")
    public Soporte obtener(@PathVariable Long id) {
        return soporteService.obtenerPorId(id);
    }

    @Operation(summary = "Crear un nuevo trabajador de soporte")
    @PostMapping
    public Soporte crear(@RequestBody Soporte soporte) {
        return soporteService.guardar(soporte);
    }

    @Operation(summary = "Crear un nuevo trabajador de soporte")
    @PutMapping("/{id}")
    public Soporte actualizar(@PathVariable Long id, @RequestBody Soporte datos) {
        return soporteService.actualizar(id, datos);
    }

    @Operation(summary = "Borrar trabajador de soporte mediante ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        soporteService.eliminar(id);
    }
}
