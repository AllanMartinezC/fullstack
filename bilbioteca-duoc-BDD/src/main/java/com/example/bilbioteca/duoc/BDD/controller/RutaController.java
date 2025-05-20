package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Ruta;
import com.example.bilbioteca.duoc.BDD.services.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rutas")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @GetMapping
    public List<Ruta> listar() {
        return rutaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Ruta obtener(@PathVariable Long id) {
        return rutaService.obtenerPorId(id);
    }

    @PostMapping
    public Ruta crear(@RequestBody Ruta ruta) {
        return rutaService.guardar(ruta);
    }

    @PutMapping("/{id}")
    public Ruta actualizar(@PathVariable Long id, @RequestBody Ruta nuevosDatos) {
        return rutaService.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rutaService.eliminar(id);
    }
}
