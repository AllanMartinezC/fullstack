package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Ruta;
import com.example.bilbioteca.duoc.BDD.repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public List<Ruta> obtenerTodas() {
        return rutaRepository.findAll();
    }

    public Ruta obtenerPorId(Long id) {
        return rutaRepository.findById(id).orElse(null);
    }

    public Ruta guardar(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public Ruta actualizar(Long id, Ruta nuevos_datosruta) {
        Ruta rutaexistente = rutaRepository.findById(id).orElse(null);
        if (rutaexistente == null) {
            return null;
        }
        rutaexistente.setOrigen(nuevos_datosruta.getOrigen());
        rutaexistente.setDestino(nuevos_datosruta.getDestino());
        rutaexistente.setPrioridad(nuevos_datosruta.getPrioridad());
        rutaexistente.setEnvio(nuevos_datosruta.getEnvio());
        return rutaRepository.save(rutaexistente);
    }

    public void eliminar(Long id) {
        rutaRepository.deleteById(id);
    }
}
