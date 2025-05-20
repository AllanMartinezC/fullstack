package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Sucursal;
import com.example.bilbioteca.duoc.BDD.repository.SucursalRepository;
import com.example.bilbioteca.duoc.BDD.services.SucursalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursales")

public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping
    public List<Sucursal> obtenerTodas() {
        return sucursalService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Sucursal obtenerPorId(@PathVariable Long id) {
        return sucursalService.obtenerPorId(id);
    }

    @PostMapping
     public ResponseEntity<Sucursal> crearSucursal(@RequestBody Sucursal sucursal) {
    Sucursal nueva = sucursalRepository.save(sucursal);
    return ResponseEntity.ok(nueva);
}

    @PutMapping("/{id}")
    public Sucursal actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursalActualizada) {
        return sucursalService.actualizar(id, sucursalActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarSucursal(@PathVariable Long id) {
        sucursalService.eliminar(id);
    }
}

