package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Resena;
import com.example.bilbioteca.duoc.BDD.services.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping
    public List<Resena> listar() {
        return resenaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Resena obtener(@PathVariable Long id) {
        return resenaService.obtenerPorId(id);
    }

    @PostMapping
    public Resena crear(@RequestBody Resena resena) {
        return resenaService.guardar(resena);
    }

    @PutMapping("/{id}")
    public Resena actualizar(@PathVariable Long id, @RequestBody Resena datos) {
        return resenaService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        resenaService.eliminar(id);
    }
}
