package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Gerente;
import com.example.bilbioteca.duoc.BDD.model.Sucursal;
import com.example.bilbioteca.duoc.BDD.repository.GerenteRepository;
import com.example.bilbioteca.duoc.BDD.repository.SucursalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private GerenteRepository gerenteRepository;

    public List<Sucursal> obtenerTodas() {
        return sucursalRepository.findAll();
    }

    public Sucursal obtenerPorId(Long id) {
        return sucursalRepository.findById(id).orElse(null);
    }

    public Sucursal crear(Sucursal sucursal) {
        if (sucursal.getGerente() != null) {
            Long id_gerente = sucursal.getGerente().getId_gerente();
            Optional<Gerente> gerenteOpt = gerenteRepository.findById(id_gerente);
            if (gerenteOpt.isEmpty()) {
                return null;
            }
            Gerente gerente = gerenteOpt.get();
            sucursal.setGerente(gerente);
            gerente.setSucursal(sucursal);
        }
        return sucursalRepository.save(sucursal);
    }

    public Sucursal actualizar(Long id, Sucursal nuevosDatos) {
        Sucursal sucursal_existente = obtenerPorId(id);
        if (sucursal_existente == null) {
            return null;
        }

        sucursal_existente.setNombre(nuevosDatos.getNombre());
        sucursal_existente.setDireccion(nuevosDatos.getDireccion());
        sucursal_existente.setHorarioApertura(nuevosDatos.getHorarioApertura());
        sucursal_existente.setHorarioCierre(nuevosDatos.getHorarioCierre());
        sucursal_existente.setPoliticasLocales(nuevosDatos.getPoliticasLocales());
        sucursal_existente.setGerente(nuevosDatos.getGerente());

        return sucursalRepository.save(sucursal_existente);
    }

    public void eliminar(Long id) {
        sucursalRepository.deleteById(id);
    }
}
