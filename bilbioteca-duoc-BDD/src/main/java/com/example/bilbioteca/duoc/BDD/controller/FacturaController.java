package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Factura;
import com.example.bilbioteca.duoc.BDD.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Factura", description = "Operaciones CRUD para Factura")
@RestController
@RequestMapping("/factura") 
public class FacturaController {

    @Autowired
    private FacturaService facturaService;


    @Operation(summary = "Obtener todas las Facturas")
    @GetMapping("/")
    public ResponseEntity<List<Factura>> obtenerTodasLasFacturas() {
        return ResponseEntity.ok(facturaService.obtenerTodasLasFacturas());
    }

    @Operation(summary = "Obtener Factura por ID")
    @GetMapping("/{idFactura}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long idFactura) {
        return ResponseEntity.ok(facturaService.obtenerFacturaPorId(idFactura));
    }
    
    @Operation(summary = "Crear una nueva Factura")
    @PostMapping("/")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.crearFactura(factura));
    }

    @Operation(summary = "Actualiar Factura por ID")
    @PutMapping("/{idFactura}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Long idFactura, @RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.actualizarFactura(idFactura, factura));
    }
    
    @Operation(summary = "Eliminar Factura por ID")
    @DeleteMapping("/{idFactura}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long idFactura) {
        facturaService.eliminarFactura(idFactura);
        return ResponseEntity.noContent().build();
    }
}
