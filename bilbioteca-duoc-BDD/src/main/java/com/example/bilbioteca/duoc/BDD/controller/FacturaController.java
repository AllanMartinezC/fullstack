package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Factura;
import com.example.bilbioteca.duoc.BDD.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura") 
public class FacturaController {

    @Autowired
    private FacturaService facturaService;
   
    @GetMapping("/")
    public ResponseEntity<List<Factura>> obtenerTodasLasFacturas() {
        return ResponseEntity.ok(facturaService.obtenerTodasLasFacturas());
    }

    @GetMapping("/{idFactura}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long idFactura) {
        return ResponseEntity.ok(facturaService.obtenerFacturaPorId(idFactura));
    }

    @PostMapping("/")
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.crearFactura(factura));
    }

    @PutMapping("/{idFactura}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Long idFactura, @RequestBody Factura factura) {
        return ResponseEntity.ok(facturaService.actualizarFactura(idFactura, factura));
    }

    @DeleteMapping("/{idFactura}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Long idFactura) {
        facturaService.eliminarFactura(idFactura);
        return ResponseEntity.noContent().build();
    }
}
