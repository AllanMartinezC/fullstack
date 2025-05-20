package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Proveedor;
import com.example.bilbioteca.duoc.BDD.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> obtenerTodos() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizar(Long id, Proveedor nuevoproveedor) {
        Proveedor proveedor_existente = proveedorRepository.findById(id).orElse(null);
        if (proveedor_existente == null) {
            return null;
        }
        proveedor_existente.setNombre(nuevoproveedor.getNombre());
        proveedor_existente.setEmail(nuevoproveedor.getEmail());
        proveedor_existente.setTelefono(nuevoproveedor.getTelefono());
        proveedor_existente.setDireccion(nuevoproveedor.getDireccion());
        return proveedorRepository.save(proveedor_existente);
    }

    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }
}
