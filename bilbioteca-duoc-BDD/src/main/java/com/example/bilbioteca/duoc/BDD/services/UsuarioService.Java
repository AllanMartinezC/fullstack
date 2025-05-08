package com.perfulandia.admin.services;

import com.perfulandia.admin.model.Usuario;
import com.perfulandia.admin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que contiene la lógica de negocio para la gestión de usuarios.
 * Proporciona métodos para crear, actualizar, eliminar y buscar usuarios.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    /**
     * Devuelve una lista con todos los usuarios.
     */
    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.findAll();
    }

    /**
     * Busca un usuario por su ID.
     */
    public Optional<Usuario> buscarPorId(Long id) {
        return repositorioUsuario.findById(id);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     */
    public Optional<Usuario> buscarPorNombreUsuario(String username) {
        return repositorioUsuario.buscarPorNombreUsuario(username);
    }

    /**
     * Busca un usuario por su correo electrónico.
     */
    public Optional<Usuario> buscarPorCorreo(String email) {
        return repositorioUsuario.buscarPorCorreo(email);
    }

    /**
     * Crea un nuevo usuario y lo guarda en la base de datos.
     */
    public Usuario crearUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    /**
     * Actualiza los datos de un usuario existente.
     */
    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    /**
     * Elimina un usuario según su ID.
     */
    public void eliminarUsuario(Long id) {
        repositorioUsuario.deleteById(id);
    }

    /**
     * Lista todos los usuarios activos.
     */
    public List<Usuario> listarUsuariosActivos() {
        return repositorioUsuario.findByActivoTrue();
    }
}
