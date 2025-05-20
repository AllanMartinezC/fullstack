package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Envio;
import com.example.bilbioteca.duoc.BDD.services.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    @Autowired
    private EnvioService envioService;

    @GetMapping
    public List<Envio> listar() {
        return envioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Envio obtener(@PathVariable Long id) {
        return envioService.obtenerPorId(id);
    }

    @PostMapping
    public Envio crear(@RequestBody Envio envio) {
        return envioService.guardar(envio);
    }

    @PutMapping("/{id}")
    public Envio actualizar(@PathVariable Long id, @RequestBody Envio nuevosDatos) {
        return envioService.actualizar(id, nuevosDatos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        envioService.eliminar(id);
    }
}
