package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Envio;
import com.example.bilbioteca.duoc.BDD.services.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Envio", description = "Operaciones CRUD para Envio")
@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @Operation(summary = "Obtener todos los Envíos")
    @GetMapping
    public List<Envio> listar() {
        return envioService.obtenerTodos();
    }
    
    @Operation(summary = "Obtener Envio por ID")
    @GetMapping("/{id}")
    public Envio obtener(@PathVariable Long id) {
        return envioService.obtenerPorId(id);
    }

    @Operation(summary = "Crear nuevo Envío")
    @PostMapping
    public Envio crear(@RequestBody Envio envio) {
        return envioService.guardar(envio);
    }

    @Operation(summary = "Actualizar Envío por ID")
    @PutMapping("/{id}")
    public Envio actualizar(@PathVariable Long id, @RequestBody Envio nuevosDatos) {
        return envioService.actualizar(id, nuevosDatos);
    }

    @Operation(summary = "Eliminar Envío por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        envioService.eliminar(id);
    }
}
