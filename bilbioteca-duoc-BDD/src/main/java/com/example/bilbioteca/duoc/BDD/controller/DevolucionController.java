package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Devolucion;
import com.example.bilbioteca.duoc.BDD.services.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Devolucion", description = "Operaciones CRUD para las Devoluciones")
@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    
    @Operation(summary = "Obtener todas las Devoluciones")
    @GetMapping
    public List<Devolucion> listar() {
        return devolucionService.obtenerTodas();
    }

    @Operation(summary = "Obtener Devolucion por ID")
    @GetMapping("/{id}")
    public Devolucion obtener(@PathVariable Long id) {
        return devolucionService.obtenerPorId(id);
    }

    @Operation(summary = "Crear nueva Devolucion")
    @PostMapping
    public Devolucion crear(@RequestBody Devolucion devolucion) {
        return devolucionService.guardar(devolucion);
    }

    @Operation(summary = "Actualizar una Devolucion")
    @PutMapping("/{id}")
    public Devolucion actualizar(@PathVariable Long id, @RequestBody Devolucion nuevosDatos) {
        return devolucionService.actualizar(id, nuevosDatos);
    }

    @Operation(summary = "Eliminar una Devolucion por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        devolucionService.eliminar(id);
    }
}
