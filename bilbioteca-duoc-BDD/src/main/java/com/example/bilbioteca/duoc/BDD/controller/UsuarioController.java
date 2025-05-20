package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Usuario;
import com.example.bilbioteca.duoc.BDD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    
    @Autowired
    private UsuarioRepository repositorioUsuario;

    
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return repositorioUsuario.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return repositorioUsuario.findById(id).orElse(null);
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @PutMapping
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repositorioUsuario.deleteById(id);
    }
}
