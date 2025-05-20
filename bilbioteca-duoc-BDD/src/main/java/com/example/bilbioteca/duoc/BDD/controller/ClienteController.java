package com.example.bilbioteca.duoc.BDD.controller;

import com.example.bilbioteca.duoc.BDD.model.Cliente;
import com.example.bilbioteca.duoc.BDD.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obtenerTodos() {
        return clienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerPorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id).orElse(null);
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

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

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
