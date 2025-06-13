package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Ruta;
import com.example.bilbioteca.duoc.BDD.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ruta", description = "Operaciones CRUD para las Rutas")
@RestController
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;
    

    @Operation(summary = "Obtener todas las rutas")
    @GetMapping
    public List<Ruta> listar() {
        return rutaService.obtenerTodas();
    }

    @Operation(summary = "Obtener ruta por ID")
    @GetMapping("/{id}")
    public Ruta obtener(@PathVariable Long id) {
        return rutaService.obtenerPorId(id);
    }

    @Operation(summary = "Crear una nueva ruta")
    @PostMapping
    public Ruta crear(@RequestBody Ruta ruta) {
        return rutaService.guardar(ruta);
    }

    @Operation(summary = "Actualizar una ruta por ID")
    @PutMapping("/{id}")
    public Ruta actualizar(@PathVariable Long id, @RequestBody Ruta nuevosDatos) {
        return rutaService.actualizar(id, nuevosDatos);
    }

    @Operation(summary = "Eliminar una ruta por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rutaService.eliminar(id);
    }
}
