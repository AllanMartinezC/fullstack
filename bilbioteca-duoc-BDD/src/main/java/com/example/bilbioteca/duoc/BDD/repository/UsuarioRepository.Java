package com.perfulandia.admin.repository;

import com.perfulandia.admin.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

/**
 * Repositorio JPA para la entidad Usuario.
 * Permite realizar operaciones CRUD sobre la tabla de usuarios.
 * Incluye métodos personalizados para buscar por distintos atributos.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username nombre de usuario
     * @return un Optional que puede contener el usuario encontrado
     */
    Optional<Usuario> buscarPorNombreUsuario(String username);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email correo electrónico
     * @return un Optional con el usuario si existe
     */
    Optional<Usuario> buscarPorCorreo(String email);

    /**
     * Lista todos los usuarios que estén activos.
     *
     * @return lista de usuarios activos
     */
    List<Usuario> findByActivoTrue();
}


