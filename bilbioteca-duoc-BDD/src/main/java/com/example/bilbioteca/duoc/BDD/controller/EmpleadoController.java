package com.example.bilbioteca.duoc.BDD.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bilbioteca.duoc.BDD.model.Empleado;
import com.example.bilbioteca.duoc.BDD.services.EmpleadoService;

@Tag(name = "Empleado", description = "Operaciones CRUD para Empleado")
@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    
    @Operation(summary = "Obtener todos los empleados")
    @GetMapping
    public List<Empleado> listarTodos() {
        return empleadoService.obtenerTodos();
    }
    
    @Operation(summary = "Crear un nuevo Empleado")
    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoService.guardar(empleado);
    }

    @Operation(summary = "Obtener empleado por ID")
    @GetMapping("/{id}")
    public Empleado obtenerPorId(@PathVariable Long id) {
        return empleadoService.obtenerPorId(id);
    }

    @Operation(summary = "Eliminar empleado por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
    }

   
}

