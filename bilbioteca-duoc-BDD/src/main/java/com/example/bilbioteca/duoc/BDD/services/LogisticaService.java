package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Logistica;
import com.example.bilbioteca.duoc.BDD.repository.LogisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogisticaService {

    @Autowired
    private LogisticaRepository logisticaRepository;

    public List<Logistica> obtenerTodos() {
        return logisticaRepository.findAll();
    }

    public Logistica obtenerPorId(Long id) {
        return logisticaRepository.findById(id).orElse(null);
    }

    public Logistica guardar(Logistica logistica) {
        return logisticaRepository.save(logistica);
    }

    public Logistica actualizar(Long id, Logistica nuevosdatos_logistica) {
        Logistica logistica_existente = logisticaRepository.findById(id).orElse(null);
        if (logistica_existente == null) {
            return null;
        }

        logistica_existente.setNombre(nuevosdatos_logistica.getNombre());
        logistica_existente.setRut(nuevosdatos_logistica.getRut());
        logistica_existente.setEmail(nuevosdatos_logistica.getEmail());
        logistica_existente.setTelefono(nuevosdatos_logistica.getTelefono());
        logistica_existente.setContrasena(nuevosdatos_logistica.getContrasena());
        logistica_existente.setRol(nuevosdatos_logistica.getRol());
        logistica_existente.setSucursal(nuevosdatos_logistica.getSucursal());

        return logisticaRepository.save(logistica_existente);
    }

    public void eliminar(Long id) {
        logisticaRepository.deleteById(id);
    }
}
