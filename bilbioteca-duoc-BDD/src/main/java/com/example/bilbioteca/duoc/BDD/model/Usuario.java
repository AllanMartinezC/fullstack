package com.perfulandia.admin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuario")
@Data // Lombok: genera getters, setters, toString, equals, hashCode
@AllArgsConstructor // Lombok: constructor con todos los atributos
@NoArgsConstructor  // Lombok: constructor vacío necesario para JPA
public class Usuario {

    // ID único del usuario (clave primaria autogenerada)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre de usuario (debe ser único y no nulo)
    @Column(nullable = false, unique = true)
    private String username;

    // Contraseña del usuario (no puede ser nula)
    @Column(nullable = false)
    private String password;

    // Correo electrónico del usuario (único y no nulo)
    @Column(nullable = false, unique = true)
    private String email;

    // Estado del usuario (true = activo, false = desactivado)
    @Column(nullable = false)
    private boolean activo = true;

    // Relación muchos-a-uno con la tabla 'rol' (rol asignado al usuario)
    @ManyToOne
    @JoinColumn(name = "rol_id") // Nombre de la columna FK en la tabla usuario
    private Rol rol;
}

