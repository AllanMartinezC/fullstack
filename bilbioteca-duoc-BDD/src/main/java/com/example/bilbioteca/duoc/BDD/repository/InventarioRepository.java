package com.example.bilbioteca.duoc.BDD.repository;

import com.example.bilbioteca.duoc.BDD.model.Inventario;
import com.example.bilbioteca.duoc.BDD.model.Sucursal;
import com.example.bilbioteca.duoc.BDD.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    List<Inventario> findBySucursal(Sucursal sucursal);

    Optional<Inventario> findBySucursalAndProducto(Sucursal sucursal, Producto producto);
}

