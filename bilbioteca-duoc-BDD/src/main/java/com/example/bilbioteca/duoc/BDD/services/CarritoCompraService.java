package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.CarritoDeCompra;
import com.example.bilbioteca.duoc.BDD.repository.CarritoDeCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoDeCompraService {

    @Autowired
    private CarritoDeCompraRepository carritoDeCompraRepository;

   
    public CarritoDeCompra guardarCarrito(CarritoDeCompra carrito) {
        return carritoDeCompraRepository.save(carrito);
    }

    public List<CarritoDeCompra> listarCarritos() {
        return carritoDeCompraRepository.findAll();
    }

    public CarritoDeCompra buscarPorId(Long id) {
        return carritoDeCompraRepository.findById(id).orElse(null);
    }

    public void eliminarCarrito(Long id) {
        carritoDeCompraRepository.deleteById(id);
    }
}
