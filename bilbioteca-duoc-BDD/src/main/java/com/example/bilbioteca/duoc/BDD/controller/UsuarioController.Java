package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Usuario;
import com.example.bilbioteca.duoc.BDD.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuarios", description = "Operaciones CRUD para usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return repositorioUsuario.findAll();
    }

    @Operation(summary = "Buscar usuario por ID")
    @GetMapping("/{id}")
    public Usuario buscarPorId(
            @Parameter(description = "ID del usuario a buscar") @PathVariable Long id) {
        return repositorioUsuario.findById(id).orElse(null);
    }

    @Operation(summary = "Guardar un nuevo usuario")
    @PostMapping
    public Usuario guardar(
            @Parameter(description = "Objeto usuario a guardar") @RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Operation(summary = "Actualizar un usuario existente")
    @PutMapping
    public Usuario actualizar(
            @Parameter(description = "Objeto usuario actualizado") @RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Operation(summary = "Eliminar un usuario por ID")
    @DeleteMapping("/{id}")
    public void eliminar(
            @Parameter(description = "ID del usuario a eliminar") @PathVariable Long id) {
        repositorioUsuario.deleteById(id);
    }
}
