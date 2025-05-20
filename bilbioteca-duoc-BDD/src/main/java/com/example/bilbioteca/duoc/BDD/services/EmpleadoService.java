package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Empleado;
import com.example.bilbioteca.duoc.BDD.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado obtenerPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }

    public Empleado buscarPorRut(String rut) {
        return empleadoRepository.findByRut(rut).orElse(null);
    }
}
