package com.example.bilbioteca.duoc.BDD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Table(name = "usuarios")
@Data 
@AllArgsConstructor 
@NoArgsConstructor  
public class Usuario {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    
    @Column(name="nombreUsuario")
    private String nombreUsuario;

    
    @Column(name="contrasena")
    private String contrasena;

    
    @Column(name="email")
    private String email;

    
    @Column(nullable = false)
    private boolean activo = true;

    
    @ManyToOne
    @JoinColumn(name = "rol_id") 
    private Rol rol;
}

