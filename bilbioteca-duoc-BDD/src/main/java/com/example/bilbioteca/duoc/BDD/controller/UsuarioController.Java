package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Rol;
import com.example.bilbioteca.duoc.BDD.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")

public class RolController {

    @Autowired
    private RolRepository repositorioRol;
    @GetMapping
    public List<Rol> obtenerRoles() {
        return repositorioRol.findAll();
    }

    @GetMapping("/{id}")
    public Rol buscarPorId(@PathVariable Long id) {
        return repositorioRol.findById(id).orElse(null);
    }

    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return repositorioRol.save(rol);
    }

    @PutMapping
    public Rol actualizar(@RequestBody Rol rol) {
        return repositorioRol.save(rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repositorioRol.deleteById(id);
    }
}
