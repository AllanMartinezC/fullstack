package com.perfulandia.admin.services;

import com.perfulandia.admin.model.Rol;
import com.perfulandia.admin.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar roles con base de datos.
 */
@Service
public class RolService {

    @Autowired
    private RolRepository repositorioRol;

    /**
     * Retorna la lista de roles desde la base de datos.
     */
    public List<Rol> obtenerRoles() {
        return repositorioRol.findAll();
    }

    /**
     * Busca un rol por su ID.
     */
    public Rol buscarPorId(Long id) {
        return repositorioRol.findById(id).orElse(null);
    }

    /**
     * Busca un rol por su nombre.
     */
    public Rol buscarPorNombre(String nombre) {
        Optional<Rol> resultado = repositorioRol.findByNombre(nombre);
        return resultado.orElse(null);
    }

    /**
     * Guarda un nuevo rol.
     */
    public Rol guardar(Rol rol) {
        return repositorioRol.save(rol);
    }

    /**
     * Actualiza un rol existente.
     */
    public Rol actualizar(Rol rol) {
        return repositorioRol.save(rol);  // JPA hace save para crear o actualizar
    }

    /**
     * Elimina un rol por su ID.
     */
    public void eliminar(Long id) {
        repositorioRol.deleteById(id);
    }
}
