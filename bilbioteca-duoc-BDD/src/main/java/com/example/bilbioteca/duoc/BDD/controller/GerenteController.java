package com.example.bilbioteca.duoc.BDD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.bilbioteca.duoc.BDD.model.Gerente;
import com.example.bilbioteca.duoc.BDD.repository.GerenteRepository;
import com.example.bilbioteca.duoc.BDD.services.GerenteService;
import java.util.List;

@Tag(name = "Gerente", description = "Operaciones CRUD para el Gerente")

@RestController
@RequestMapping("/gerentes")


public class GerenteController {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private GerenteService gerenteService; 

    @Operation(summary = "Crear un nuevo Gerente")
    @PostMapping
    public ResponseEntity<Gerente> crearGerente(@RequestBody Gerente gerente) {
        Gerente nuevoGerente = gerenteRepository.save(gerente);
        return ResponseEntity.ok(nuevoGerente);
    }

    @Operation(summary = "Obtener todos los Gerentes")
    @GetMapping
    public List<Gerente> obtenerTodos() {
        return gerenteRepository.findAll();
    }

    @Operation(summary = "Obtener Gerente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Gerente> obtenerPorId(@PathVariable Long id) {
        return gerenteRepository.findById(id)
                .map(gerente -> ResponseEntity.ok(gerente))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Operation(summary = "Borrar Gerente por ID")
    @DeleteMapping("/{id}")
public ResponseEntity<Void> eliminarGerente(@PathVariable Long id) {
    gerenteService.eliminarGerente(id);
    return ResponseEntity.noContent().build();
}

}



