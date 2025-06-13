package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Usuario;
import com.example.bilbioteca.duoc.BDD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Tag(name = "Usuario", description = "Operaciones CRUD para el Usuario")
@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Operation(summary = "Obtener todos los Usuarios")
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return repositorioUsuario.findAll();
    }
    
    @Operation(summary = "Obtener Usuario por ID")
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return repositorioUsuario.findById(id).orElse(null);
    }

    @Operation(summary = "Guardar Usuario")
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }
    
    @Operation(summary = "Actualizar Usuario")
    @PutMapping
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    
    @Operation(summary = "Eliminar Usuario por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repositorioUsuario.deleteById(id);
    }
}
