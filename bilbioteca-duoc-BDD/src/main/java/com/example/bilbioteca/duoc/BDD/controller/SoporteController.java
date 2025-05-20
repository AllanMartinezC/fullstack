package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Soporte;
import com.example.bilbioteca.duoc.BDD.services.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soporte")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    @GetMapping
    public List<Soporte> listar() {
        return soporteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Soporte obtener(@PathVariable Long id) {
        return soporteService.obtenerPorId(id);
    }

    @PostMapping
    public Soporte crear(@RequestBody Soporte soporte) {
        return soporteService.guardar(soporte);
    }

    @PutMapping("/{id}")
    public Soporte actualizar(@PathVariable Long id, @RequestBody Soporte datos) {
        return soporteService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        soporteService.eliminar(id);
    }
}
