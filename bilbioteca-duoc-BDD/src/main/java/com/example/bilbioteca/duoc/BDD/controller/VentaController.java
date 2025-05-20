package com.example.bilbioteca.duoc.BDD.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bilbioteca.duoc.BDD.model.Venta;
import com.example.bilbioteca.duoc.BDD.services.VentaService;


@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> obtenerVentas() {
        return ventaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorId(@PathVariable Long id) {
        return ventaService.obtenerPorId(id);
    }

    @PostMapping
    public Venta guardarVenta(@RequestBody Venta venta) {
        return ventaService.guardar(venta);
    }

    @DeleteMapping("/{id}")
    public void eliminarVenta(@PathVariable Long id) {
        ventaService.eliminar(id);
    }
}
