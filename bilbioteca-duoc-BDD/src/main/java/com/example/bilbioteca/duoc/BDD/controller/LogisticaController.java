package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Logistica;
import com.example.bilbioteca.duoc.BDD.services.LogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/logistica")
public class LogisticaController {

    @Autowired
    private LogisticaService logisticaService;

    @Operation(summary = "Obtener todos los Empleados de Logistica")
    @GetMapping
    public List<Logistica> listar() {
        return logisticaService.obtenerTodos();
    }

    @Operation(summary = "Obtener empleado Logistica por ID")
    @GetMapping("/{id}")
    public Logistica obtener(@PathVariable Long id) {
        return logisticaService.obtenerPorId(id);
    }

    @Operation(summary = "Crear un nuevo Empleado de Logistica")
    @PostMapping
    public Logistica crear(@RequestBody Logistica logistica) {
        return logisticaService.guardar(logistica);
    }

    @Operation(summary = "Actualizar Empleado Logistica por ID")
    @PutMapping("/{id}")
    public Logistica actualizar(@PathVariable Long id, @RequestBody Logistica nuevosDatos) {
        return logisticaService.actualizar(id, nuevosDatos);
    }

    @Operation(summary = "Eliminar Empleado Logistica por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        logisticaService.eliminar(id);
    }
}
