package com.laempacadora.persistence;

import com.laempacadora.persistence.crud.ProductoCrudRepository;
import com.laempacadora.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll()
    {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> findByNombre(String nombre)
    {
        return productoCrudRepository.findByNombreContaining(nombre);
    }

    public Optional<Producto> getProducto(int idProducto)
    {
        return productoCrudRepository.findById(idProducto);
    }

    public void delete(int idProducto)
    {
        productoCrudRepository.deleteById(idProducto);
    }

    public Producto save(Producto producto)
    {
        return productoCrudRepository.save(producto);
    }

    public Producto update(Producto producto)
    {
        return productoCrudRepository.save(producto);
    }
}
