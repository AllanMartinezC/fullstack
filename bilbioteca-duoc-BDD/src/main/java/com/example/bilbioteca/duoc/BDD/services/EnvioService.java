package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Envio;
import com.example.bilbioteca.duoc.BDD.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public Envio obtenerPorId(Long id) {
        return envioRepository.findById(id).orElse(null);
    }

    public Envio guardar(Envio envio) {
        return envioRepository.save(envio);
    }

    public Envio actualizar(Long id, Envio nuevosdatos_envio) {
        Envio envio_existente = envioRepository.findById(id).orElse(null);
        if (envio_existente == null) {
            return null;
        }

        envio_existente.setOrigen(nuevosdatos_envio.getOrigen());
        envio_existente.setDestino(nuevosdatos_envio.getDestino());
        envio_existente.setEstado(nuevosdatos_envio.getEstado());
        envio_existente.setFechaEnvio(nuevosdatos_envio.getFechaEnvio());
        envio_existente.setResponsable_Logistica(nuevosdatos_envio.getResponsable_Logistica());

        return envioRepository.save(envio_existente);
    }

    public void eliminar(Long id) {
        envioRepository.deleteById(id);
    }
}

