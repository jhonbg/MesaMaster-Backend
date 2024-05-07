package com.laempacadora.web.controller;

import com.laempacadora.domain.service.ProductoService;
import com.laempacadora.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAll()
    {
        return new ResponseEntity<>(productoService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>> getProducto(@PathVariable("id") int idProducto)
    {
        return new ResponseEntity<>(productoService.getProducto(idProducto),HttpStatus.OK);
    }

    @GetMapping("/search/{nombre}")
    public ResponseEntity<List<Producto>> searchByName(@PathVariable String nombre) {
        return new ResponseEntity<>(productoService.searchByName(nombre), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Producto> save(@RequestBody Producto producto)
    {
        return new ResponseEntity<>(productoService.save(producto),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int idProducto)
    {
        if(productoService.getProducto(idProducto).isPresent())
        {
            return new ResponseEntity<>(productoService.delete(idProducto),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(false,HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Producto> update(@RequestBody Producto producto)
    {
        if(productoService.getProducto(producto.getIdProducto()).isPresent())
        {
            return new ResponseEntity<>(productoService.update(producto),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
