package com.perfulandia.admin.repository;

import com.perfulandia.admin.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio JPA para la entidad Rol.
 * Permite operaciones CRUD y búsqueda personalizada por nombre.
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    /**
     * Busca un rol por su nombre.
     * 
     * @param nombre nombre del rol
     * @return Optional con el resultado encontrado
     */
    Optional<Rol> findByNombre(String nombre);
}
