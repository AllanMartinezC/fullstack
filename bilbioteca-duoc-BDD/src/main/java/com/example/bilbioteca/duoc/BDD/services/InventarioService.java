package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.Inventario;
import com.example.bilbioteca.duoc.BDD.model.Producto;
import com.example.bilbioteca.duoc.BDD.model.Sucursal;
import com.example.bilbioteca.duoc.BDD.repository.InventarioRepository;
import com.example.bilbioteca.duoc.BDD.repository.ProductoRepositoryJPA;
import com.example.bilbioteca.duoc.BDD.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ProductoRepositoryJPA productoRepositoryJPA;

    public List<Inventario> obtenerInventarioPorSucursal(Long idSucursal) {
        Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
        if (sucursal == null) {
            return null;
        }
        return inventarioRepository.findBySucursal(sucursal);
    }

    public Inventario agregarProductoAInventario(Long idSucursal, Long idProducto, Long cantidad) {
        Sucursal sucursal = sucursalRepository.findById(idSucursal).orElse(null);
        Producto producto = productoRepositoryJPA.findById(idProducto).orElse(null);

        if (sucursal == null || producto == null) {
            return null;
        }

        Inventario inventario = inventarioRepository.findBySucursalAndProducto(sucursal, producto).orElse(null);

        if (inventario != null) {
            inventario.setCantidad(inventario.getstock() + cantidad);
            return inventarioRepository.save(inventario);
        }

        Inventario nuevo = new Inventario(null, sucursal, producto, cantidad);
        return inventarioRepository.save(nuevo);
    }

    public Inventario actualizarStock(Long idInventario, Long nuevaCantidad) {
        Inventario inventario = inventarioRepository.findById(idInventario).orElse(null);
        if (inventario == null) {
            return null;
        }

        inventario.setCantidad(nuevaCantidad);
        return inventarioRepository.save(inventario);
    }

    public void eliminarDelInventario(Long idInventario) {
        inventarioRepository.deleteById(idInventario);
    }

    public List<Inventario> obtenerTodo() {
        return inventarioRepository.findAll();
    }

    public List<Inventario> obtenerTodosLosInventarios() {
        return inventarioRepository.findAll();
    }
}
