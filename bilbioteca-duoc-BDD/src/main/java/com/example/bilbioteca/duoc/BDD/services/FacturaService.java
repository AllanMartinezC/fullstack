package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Factura;
import com.example.bilbioteca.duoc.BDD.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepository.findAll();
    }

    public Factura obtenerFacturaPorId(Long idFactura) {
        return facturaRepository.findById(idFactura).orElse(null);
    }

    public Factura crearFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura actualizarFactura(Long idFactura, Factura factura) {
        if (!facturaRepository.existsById(idFactura)) {
            return null;
        }
        factura.setIdFactura(idFactura);
        return facturaRepository.save(factura);
    }

    public void eliminarFactura(Long idFactura) {
        if (facturaRepository.existsById(idFactura)) {
            facturaRepository.deleteById(idFactura);
        }
    }
}
