package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.CuponDescuento;
import com.example.bilbioteca.duoc.BDD.repository.CuponDescuentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuponDescuentoService {

    @Autowired
    private CuponDescuentoRepository cuponRepository;

    public List<CuponDescuento> obtenerTodos() {
        return cuponRepository.findAll();
    }

    public CuponDescuento obtenerPorId(Long id) {
        return cuponRepository.findById(id).orElse(null);
    }

    public CuponDescuento guardar(CuponDescuento cupon) {
        return cuponRepository.save(cupon);
    }

    public CuponDescuento actualizar(Long id, CuponDescuento nuevocupon) {
        CuponDescuento cuponactual = cuponRepository.findById(id).orElse(null);
        if (cuponactual == null) return null;
        cuponactual.setCodigo(nuevocupon.getCodigo());
        cuponactual.setPorcentaje(nuevocupon.getPorcentaje());
        cuponactual.setActivo(nuevocupon.isActivo());
        return cuponRepository.save(cuponactual);
    }

    public void eliminar(Long id) {
        cuponRepository.deleteById(id);
    }
}
