package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.CuponDescuento;
import com.example.bilbioteca.duoc.BDD.services.CuponDescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cupones")
public class CuponDescuentoController {

    @Autowired
    private CuponDescuentoService cuponService;

    @GetMapping
    public List<CuponDescuento> listar() {
        return cuponService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public CuponDescuento obtener(@PathVariable Long id) {
        return cuponService.obtenerPorId(id);
    }

    @PostMapping
    public CuponDescuento crear(@RequestBody CuponDescuento cupon) {
        return cuponService.guardar(cupon);
    }

    @PutMapping("/{id}")
    public CuponDescuento actualizar(@PathVariable Long id, @RequestBody CuponDescuento datos) {
        return cuponService.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cuponService.eliminar(id);
    }
}
