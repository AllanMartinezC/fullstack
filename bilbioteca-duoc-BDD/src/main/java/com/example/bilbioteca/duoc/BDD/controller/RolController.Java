package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Rol;
import com.example.bilbioteca.duoc.BDD.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Rol", description = "Operaciones CRUD para el Rol")
@RestController
@RequestMapping("/roles")

public class RolController {

    @Autowired
    private RolRepository repositorioRol;

    @Operation(summary = "Obtener todos los roles")
    @GetMapping
    public List<Rol> obtenerRoles() {
        return repositorioRol.findAll();
    }

    @Operation(summary = "Obtener rol por ID")
    @GetMapping("/{id}")
    public Rol buscarPorId(@PathVariable Long id) {
        return repositorioRol.findById(id).orElse(null);
    }

    @Operation(summary = "Crear un nuevo Rol")
    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return repositorioRol.save(rol);
    }

    @Operation(summary = "Actualizar rol")

    @PutMapping
    public Rol actualizar(@RequestBody Rol rol) {
        return repositorioRol.save(rol);
    }

    @Operation(summary = "Eliminar rol por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repositorioRol.deleteById(id);
    }
}
