package com.laempacadora.domain.service;

import com.laempacadora.persistence.ProductoRepository;
import com.laempacadora.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAll()
    {
        return productoRepository.getAll();
    }

    public Optional<Producto> getProducto(int idProducto)
    {
        return productoRepository.getProducto(idProducto);
    }

    public List<Producto> searchByName(String nombre)
    {
        return productoRepository.findByNombre(nombre);
    }

    public Producto save(Producto producto)
    {
            return productoRepository.save(producto);
    }

    public boolean delete(int idProducto)
    {
        return getProducto(idProducto).map(producto -> {
            productoRepository.delete(idProducto);
            return true;
        }).orElse(false);
    }

    public boolean exists(int idProducto)
    {
        boolean exists;
        exists = productoRepository.getProducto(idProducto).isPresent();
        return exists;
    }

    public Producto update(Producto producto)
    {
        return productoRepository.update(producto);
    }
}
