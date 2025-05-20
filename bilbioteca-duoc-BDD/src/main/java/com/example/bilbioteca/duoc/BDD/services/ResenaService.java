package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Resena;
import com.example.bilbioteca.duoc.BDD.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    public List<Resena> obtenerTodas() {
        return resenaRepository.findAll();
    }

    public Resena obtenerPorId(Long id) {
        return resenaRepository.findById(id).orElse(null);
    }

    public Resena guardar(Resena resena) {
        return resenaRepository.save(resena);
    }

    public Resena actualizar(Long id, Resena actualizarresena) {
        Resena resena_Actual = resenaRepository.findById(id).orElse(null);
        if (resena_Actual == null) return null;

        resena_Actual.setCliente(actualizarresena.getCliente());
        resena_Actual.setProducto(actualizarresena.getProducto());
        resena_Actual.setCalificacion(actualizarresena.getCalificacion());
        resena_Actual.setComentario(actualizarresena.getComentario());

        return resenaRepository.save(resena_Actual);
    }

    public void eliminar(Long id) {
        resenaRepository.deleteById(id);
    }
}
