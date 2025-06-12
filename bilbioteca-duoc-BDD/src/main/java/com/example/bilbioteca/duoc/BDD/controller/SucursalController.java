package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Sucursal;
import com.example.bilbioteca.duoc.BDD.repository.SucursalRepository;
import com.example.bilbioteca.duoc.BDD.services.SucursalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sucursales", description = "Operaciones CRUD para sucursales")
@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Operation(summary = "Obtener todas las sucursales")
    @GetMapping
    public List<Sucursal> obtenerTodas() {
        return sucursalService.obtenerTodas();
    }

    @Operation(summary = "Obtener sucursal por ID")
    @GetMapping("/{id}")
    public Sucursal obtenerPorId(
            @Parameter(description = "ID de la sucursal") @PathVariable Long id) {
        return sucursalService.obtenerPorId(id);
    }

    @Operation(summary = "Crear una nueva sucursal")
    @PostMapping
    public ResponseEntity<Sucursal> crearSucursal(
            @Parameter(description = "Sucursal a crear") @RequestBody Sucursal sucursal) {
        Sucursal nueva = sucursalRepository.save(sucursal);
        return ResponseEntity.ok(nueva);
    }

    @Operation(summary = "Actualizar una sucursal existente")
    @PutMapping("/{id}")
    public Sucursal actualizarSucursal(
            @Parameter(description = "ID de la sucursal a actualizar") @PathVariable Long id,
            @Parameter(description = "Datos actualizados de la sucursal") @RequestBody Sucursal sucursalActualizada) {
        return sucursalService.actualizar(id, sucursalActualizada);
    }

    @Operation(summary = "Eliminar una sucursal por ID")
    @DeleteMapping("/{id}")
    public void eliminarSucursal(
            @Parameter(description = "ID de la sucursal a eliminar") @PathVariable Long id) {
        sucursalService.eliminar(id);
    }
}


