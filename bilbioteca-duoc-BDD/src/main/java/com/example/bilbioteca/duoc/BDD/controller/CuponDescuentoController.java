package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.CuponDescuento;
import com.example.bilbioteca.duoc.BDD.services.CuponDescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Cupon de Descuento", description = "Operaciones CRUD para Cupon de Descuento")
@RestController
@RequestMapping("/cupones")
public class CuponDescuentoController {

    @Autowired
    private CuponDescuentoService cuponService;
    
    @Operation(summary = "Obtener todos los Cupones de Descuento")
    @GetMapping
    public List<CuponDescuento> listar() {
        return cuponService.obtenerTodos();
    }

    @Operation(summary = "Obtener Cupon de Descuento por ID")
    @GetMapping("/{id}")
    public CuponDescuento obtener(@PathVariable Long id) {
        return cuponService.obtenerPorId(id);
    }

    @Operation(summary = "Crear un nuevo Cupon de Descuento")
    @PostMapping
    public CuponDescuento crear(@RequestBody CuponDescuento cupon) {
        return cuponService.guardar(cupon);
    }

    @Operation(summary = "Actualizar Cupon de Descuento por ID")
    @PutMapping("/{id}")
    public CuponDescuento actualizar(@PathVariable Long id, @RequestBody CuponDescuento datos) {
        return cuponService.actualizar(id, datos);
    }

    @Operation(summary = "Eliminar Cupon de Descuento por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cuponService.eliminar(id);
    }
}
