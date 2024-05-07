package com.laempacadora.web.controller;

import com.laempacadora.domain.service.DetallePedidoService;
import com.laempacadora.persistence.entity.DetallePedido;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalleproducto")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping("/all")
    public ResponseEntity<List<DetallePedido>> getAll()
    {
        return new ResponseEntity<>(detallePedidoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/pedido/{id}")
    public  ResponseEntity<List<DetallePedido>> getPedido(@PathVariable("id") int idPedido)
    {
        return new ResponseEntity<>(detallePedidoService.getPedido(idPedido),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DetallePedido>> getDetallePedido(@PathVariable("id") int idDetallePedido)
    {
        return new ResponseEntity<>(detallePedidoService.getDetallePedido(idDetallePedido),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int idDetallePedido)
    {
        return new ResponseEntity<>(detallePedidoService.delete(idDetallePedido),HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<DetallePedido> save(@RequestBody DetallePedido detallePedido)
    {
        return new ResponseEntity<>(detallePedidoService.save(detallePedido),HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<DetallePedido> update(@RequestBody DetallePedido detallePedido)
    {
        if(detallePedidoService.exists(detallePedido.getIdDetallePedido()) == true)
        {
            return new ResponseEntity<>(detallePedidoService.update(detallePedido),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
