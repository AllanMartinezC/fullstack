package com.example.bilbioteca.duoc.BDD.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bilbioteca.duoc.BDD.model.Cliente;
import com.example.bilbioteca.duoc.BDD.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

   
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
  
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
   
    public Optional<Cliente> obtenerClientePorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    
    public Optional<Cliente> obtenerClientePorNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
}
