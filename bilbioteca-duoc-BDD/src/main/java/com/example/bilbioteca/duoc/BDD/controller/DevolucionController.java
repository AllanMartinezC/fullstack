package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Devolucion;
import com.example.bilbioteca.duoc.BDD.services.DevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    @Autowired
    private DevolucionService devolucionService;

    @GetMapping
    public List<Devolucion> listar() {
        return devolucionService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Devolucion obtener(@PathVariable Long id) {
        return devolucionService.obtenerPorId(id);
    }

    @PostMapping
    public Devolucion crear(@RequestBody Devolucion devolucion) {
        return devolucionService.guardar(devolucion);
    }

    @PutMapping("/{id}")
    public Devolucion actualizar(@PathVariable Long id, @RequestBody Devolucion nuevosDatos) {
        return devolucionService.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        devolucionService.eliminar(id);
    }
}
