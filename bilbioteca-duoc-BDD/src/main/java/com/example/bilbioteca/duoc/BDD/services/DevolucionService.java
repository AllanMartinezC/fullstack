package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Devolucion;
import com.example.bilbioteca.duoc.BDD.repository.DevolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionService {

    @Autowired
    private DevolucionRepository devolucionRepository;

    public List<Devolucion> obtenerTodas() {
        return devolucionRepository.findAll();
    }

    public Devolucion obtenerPorId(Long id) {
        return devolucionRepository.findById(id).orElse(null);
    }

    public Devolucion guardar(Devolucion devolucion) {
        return devolucionRepository.save(devolucion);
    }

    public Devolucion actualizar(Long id, Devolucion nueva_devolucion) {
        Devolucion devolucion_actual = devolucionRepository.findById(id).orElse(null);
        if (devolucion_actual == null) return null;

        devolucion_actual.setVenta(nueva_devolucion.getVenta());
        devolucion_actual.setProducto(nueva_devolucion.getProducto());
        devolucion_actual.setCantidadDevuelta(nueva_devolucion.getCantidadDevuelta());
        devolucion_actual.setMotivo(nueva_devolucion.getMotivo());

        return devolucionRepository.save(devolucion_actual);
    }

    public void eliminar(Long id) {
        devolucionRepository.deleteById(id);
    }
}
