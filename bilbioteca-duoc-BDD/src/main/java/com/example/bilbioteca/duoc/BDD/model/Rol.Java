package com.perfulandia.admin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa los roles o perfiles asignables a los usuarios del sistema.
 * Ejemplos de roles: ADMINISTRADOR, GERENTE, VENDEDOR, etc.
 */
@Entity
@Table(name = "rol")
@Data // Lombok: genera automáticamente getters, setters, toString, etc.
@AllArgsConstructor // Lombok: constructor con todos los atributos
@NoArgsConstructor  // Lombok: constructor vacío (requerido por JPA)
public class Rol {

    // Identificador único del rol (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre del rol (debe ser único y no nulo)
    @Column(nullable = false, unique = true)
    private String nombre;
}
