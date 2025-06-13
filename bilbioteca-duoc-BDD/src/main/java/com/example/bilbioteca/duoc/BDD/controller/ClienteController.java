package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Cliente;
import com.example.bilbioteca.duoc.BDD.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clientes", description = "Operaciones CRUD para Cliente")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @Operation(summary = "Obtener todas los Clientes")
    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteService.obtenerTodosLosClientes();
    }

    @Operation(summary = "Obtener Cliente por ID")
    @GetMapping("/{id}")
    public Cliente obtenerPorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id).orElse(null);
    }

    @Operation(summary = "Crear un nuevo Client")
    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }


    @Operation(summary = "Actualizar un Cliente por ID")
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente datos) {
        return clienteService.obtenerClientePorId(id).map(cliente -> {
            cliente.setNombre(datos.getNombre());
            cliente.setEmail(datos.getEmail());
            cliente.setContrasena(datos.getContrasena());
            cliente.setDireccionEnvio(datos.getDireccionEnvio());
            cliente.setTelefono(datos.getTelefono());
            cliente.setRol(datos.getRol());
            return clienteService.guardarCliente(cliente);
        }).orElse(null);
    }

    @Operation(summary = "Eliminar un Cliente por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
