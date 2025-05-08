package com.perfulandia.admin.controller;

import com.perfulandia.admin.model.Usuario;
import com.perfulandia.admin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar usuarios del sistema.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    /**
     * Retorna todos los usuarios registrados.
     */
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return repositorioUsuario.findAll();
    }

    /**
     * Busca un usuario por su ID.
     */
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return repositorioUsuario.findById(id).orElse(null);
    }

    /**
     * Crea un nuevo usuario.
     */
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    /**
     * Actualiza los datos de un usuario existente.
     */
    @PutMapping
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    /**
     * Elimina un usuario por su ID.
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repositorioUsuario.deleteById(id);
    }
}
