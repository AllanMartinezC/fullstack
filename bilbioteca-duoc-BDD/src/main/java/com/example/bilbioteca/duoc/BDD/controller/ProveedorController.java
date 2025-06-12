package com.example.bilbioteca.duoc.BDD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bilbioteca.duoc.BDD.model.Proveedor;
import com.example.bilbioteca.duoc.BDD.services.ProveedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Proveedor", description = "Operaciones CRUD para proveedores")
@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Operation(summary = "Obtener todas los proveedores")
    @GetMapping
    public List<Proveedor> listar() {
        return proveedorService.obtenerTodos();
    }

    @Operation(summary = "Obtener todas los proveedores por ID")    
    @GetMapping("/{id}")
    public Proveedor obtener(@PathVariable Long id) {
        return proveedorService.obtenerPorId(id);
    }

    @Operation(summary = "Ingresar un proveedor")    
    @PostMapping
    public Proveedor crear(@RequestBody Proveedor proveedor) {
        return proveedorService.guardar(proveedor);
    }

    @Operation(summary = "Actualizar un proveedor por ID")    
    @PutMapping("/{id}")
    public Proveedor actualizar(@PathVariable Long id, @RequestBody Proveedor nuevosDatos) {
        return proveedorService.actualizar(id, nuevosDatos);
    }


    @Operation(summary = "Borrar proveedor por ID")    
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
    }
}
