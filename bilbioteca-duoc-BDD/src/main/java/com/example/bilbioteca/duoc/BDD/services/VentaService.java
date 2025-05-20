package com.example.bilbioteca.duoc.BDD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bilbioteca.duoc.BDD.model.Venta;
import com.example.bilbioteca.duoc.BDD.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerPorId(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public void eliminar(Long id) {
        ventaRepository.deleteById(id);
    }
}
