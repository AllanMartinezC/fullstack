package com.example.bilbioteca.duoc.BDD.services;

import com.example.bilbioteca.duoc.BDD.model.ItemCarrito;
import com.example.bilbioteca.duoc.BDD.repository.ItemCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCarritoService {

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    public ItemCarrito guardarItem(ItemCarrito item) {
        return itemCarritoRepository.save(item);
    }

    public List<ItemCarrito> listarItems() {
        return itemCarritoRepository.findAll();
    }

    public ItemCarrito buscarPorId(Long id) {
        return itemCarritoRepository.findById(id).orElse(null);
    }

    public void eliminarItem(Long id) {
        itemCarritoRepository.deleteById(id);
    }
}
