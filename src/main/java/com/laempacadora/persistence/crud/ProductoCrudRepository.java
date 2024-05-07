package com.laempacadora.persistence.crud;

import com.laempacadora.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByNombreContaining(@Param("nombre") String nombre);
}
