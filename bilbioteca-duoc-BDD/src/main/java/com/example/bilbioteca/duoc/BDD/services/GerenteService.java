package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Gerente;
import com.example.bilbioteca.duoc.BDD.model.Sucursal;
import com.example.bilbioteca.duoc.BDD.repository.GerenteRepository;
import com.example.bilbioteca.duoc.BDD.repository.SucursalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository gerenteRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    public Gerente obtenerPorId(Long id) {
        return gerenteRepository.findById(id).orElse(null);
    }

    @Transactional
    public void eliminarGerente(Long id) {
        Gerente gerente = gerenteRepository.findById(id).orElse(null);
        if (gerente == null) {
            return;
        }

        List<Sucursal> sucursales = sucursalRepository.findByGerente(gerente);
        for (Sucursal sucursal : sucursales) {
            sucursal.setGerente(null);
            sucursalRepository.save(sucursal);
        }

        gerenteRepository.deleteById(id);
    }
}
