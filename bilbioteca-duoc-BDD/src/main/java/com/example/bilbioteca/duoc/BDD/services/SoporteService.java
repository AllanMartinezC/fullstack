package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Soporte;
import com.example.bilbioteca.duoc.BDD.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SoporteService {

    @Autowired
    private SoporteRepository soporteRepository;

    public List<Soporte> obtenerTodos() {
        return soporteRepository.findAll();
    }

    public Soporte obtenerPorId(Long id) {
        return soporteRepository.findById(id).orElse(null);
    }

    public Soporte guardar(Soporte soporte) {
        return soporteRepository.save(soporte);
    }

    public Soporte actualizar(Long id, Soporte nuevainfosoporte) {
        Soporte soporte_actual = soporteRepository.findById(id).orElse(null);
        if (soporte_actual == null) return null;
        soporte_actual.setAsunto(nuevainfosoporte.getAsunto());
        soporte_actual.setMensaje(nuevainfosoporte.getMensaje());
        soporte_actual.setCliente(nuevainfosoporte.getCliente());
        return soporteRepository.save(soporte_actual);
    }

    public void eliminar(Long id) {
        soporteRepository.deleteById(id);
    }
}
