package com.example.bilbioteca.duoc.BDD.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.bilbioteca.duoc.BDD.model.Producto;

@Repository
public class ProductoRepository {

    private List<Producto> listaProductos = new ArrayList<>();

    public List<Producto> obtenerProductos() {
        return listaProductos;
    }

    public Producto buscarPorId(int id) {
        for (Producto p : listaProductos) {
            if (p.getId_producto() == id) {
                return p;
            }
        }
        return null;
    }

    public Producto guardar(Producto producto) {
        listaProductos.add(producto);
        return producto;
    }

    public Producto actualizar(Producto productoActualizado) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId_producto() == productoActualizado.getId_producto()) {
                listaProductos.set(i, productoActualizado);
                return productoActualizado;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        Producto producto = buscarPorId(id);
        if (producto != null) {
            listaProductos.remove(producto);
        }
    }

    public Producto ajustarStock(int id, int cantidad) {
        Producto producto = buscarPorId(id);
        if (producto != null) {
            producto.setStock(producto.getStock() + cantidad);
        }
        return producto;
    }
}
