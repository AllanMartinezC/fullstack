package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Reclamo;
import com.example.bilbioteca.duoc.BDD.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamoService {

    @Autowired
    private ReclamoRepository reclamoRepository;

    public List<Reclamo> obtenerTodos() {
        return reclamoRepository.findAll();
    }

    public Reclamo obtenerPorId(Long id) {
        return reclamoRepository.findById(id).orElse(null);
    }

    public Reclamo guardar(Reclamo reclamo) {
        return reclamoRepository.save(reclamo);
    }

    public Reclamo actualizar(Long id, Reclamo nuevos_reclamo) {
        Reclamo reclamo_actual = reclamoRepository.findById(id).orElse(null);
        if (reclamo_actual == null) return null;

        reclamo_actual.setCliente(nuevos_reclamo.getCliente());
        reclamo_actual.setDescripcion(nuevos_reclamo.getDescripcion());

        return reclamoRepository.save(reclamo_actual);
    }

    public void eliminar(Long id) {
        reclamoRepository.deleteById(id);
    }
}
