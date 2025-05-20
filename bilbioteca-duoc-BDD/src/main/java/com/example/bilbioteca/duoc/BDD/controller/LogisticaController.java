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

    @GetMapping
    public List<Logistica> listar() {
        return logisticaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Logistica obtener(@PathVariable Long id) {
        return logisticaService.obtenerPorId(id);
    }

    @PostMapping
    public Logistica crear(@RequestBody Logistica logistica) {
        return logisticaService.guardar(logistica);
    }

    @PutMapping("/{id}")
    public Logistica actualizar(@PathVariable Long id, @RequestBody Logistica nuevosDatos) {
        return logisticaService.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        logisticaService.eliminar(id);
    }
}
