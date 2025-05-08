package com.perfulandia.admin.controller;

import com.perfulandia.admin.model.Rol;
import com.perfulandia.admin.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar roles del sistema.
 */
@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolRepository repositorioRol;

    /**
     * Retorna todos los roles registrados.
     */
    @GetMapping
    public List<Rol> obtenerRoles() {
        return repositorioRol.findAll();
    }

    /**
     * Busca un rol por su ID.
     */
    @GetMapping("/{id}")
    public Rol buscarPorId(@PathVariable Long id) {
        return repositorioRol.findById(id).orElse(null);
    }

    /**
     * Crea un nuevo rol.
     */
    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return repositorioRol.save(rol);
    }

    /**
     * Actualiza los datos de un rol existente.
     */
    @PutMapping
    public Rol actualizar(@RequestBody Rol rol) {
        return repositorioRol.save(rol);
    }

    /**
     * Elimina un rol por su ID.
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repositorioRol.deleteById(id);
    }
}
