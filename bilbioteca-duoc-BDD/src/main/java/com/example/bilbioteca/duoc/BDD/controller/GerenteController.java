package com.example.bilbioteca.duoc.BDD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bilbioteca.duoc.BDD.model.Gerente;

import com.example.bilbioteca.duoc.BDD.repository.GerenteRepository;
import com.example.bilbioteca.duoc.BDD.services.GerenteService;

import java.util.List;

@RestController
@RequestMapping("/gerentes")


public class GerenteController {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private GerenteService gerenteService; 

    @PostMapping
    public ResponseEntity<Gerente> crearGerente(@RequestBody Gerente gerente) {
        Gerente nuevoGerente = gerenteRepository.save(gerente);
        return ResponseEntity.ok(nuevoGerente);
    }

    @GetMapping
    public List<Gerente> obtenerTodos() {
        return gerenteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gerente> obtenerPorId(@PathVariable Long id) {
        return gerenteRepository.findById(id)
                .map(gerente -> ResponseEntity.ok(gerente))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarGerente(@PathVariable Long id) {
    gerenteService.eliminarGerente(id);
    return ResponseEntity.noContent().build();
}

}



