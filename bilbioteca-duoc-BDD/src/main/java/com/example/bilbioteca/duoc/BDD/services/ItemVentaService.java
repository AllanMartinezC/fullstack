package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.ItemVenta;
import com.example.bilbioteca.duoc.BDD.model.Producto;
import com.example.bilbioteca.duoc.BDD.repository.ItemVentaRepository;
import com.example.bilbioteca.duoc.BDD.repository.ProductoRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVentaService {

    @Autowired
    private ItemVentaRepository itemVentaRepository;

    @Autowired
    private ProductoRepositoryJPA productoRepositoryJPA;

    public List<ItemVenta> obtenerTodos() {
        return itemVentaRepository.findAll();
    }

    public ItemVenta guardarItem(ItemVenta itemVenta) {
        Optional<Producto> productoOpt = productoRepositoryJPA.findById(itemVenta.getProducto().getId_producto());

        if (productoOpt.isEmpty()) {
            return null; 
        }

        Producto producto = productoOpt.get();

        if (producto.getStock() < itemVenta.getCantidad()) {
            return null; 
        }

        producto.setStock(producto.getStock() - itemVenta.getCantidad());
        productoRepositoryJPA.save(producto);

        asignarPrecioUnitario(itemVenta, producto);

        return itemVentaRepository.save(itemVenta);
    }

    public void eliminarItem(Long id) {
        itemVentaRepository.deleteById(id);
    }

    private void asignarPrecioUnitario(ItemVenta itemVenta, Producto producto) {
        itemVenta.setPrecioUnitario(producto.getPrecio());
    }
}
