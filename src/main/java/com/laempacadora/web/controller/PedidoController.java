package com.laempacadora.web.controller;

import com.laempacadora.domain.EstadoPedido;
import com.laempacadora.domain.service.PedidoService;
import com.laempacadora.persistence.entity.Empleado;
import com.laempacadora.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/all")
    public ResponseEntity<List<Pedido>> getAll()
    {
        return new ResponseEntity<>(pedidoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/Estado/{estado}")
    public List<Pedido> getPedidoEstado(@PathVariable EstadoPedido estado)
    {
        LocalDate fecha = LocalDate.now();
        return pedidoService.getPedidoEstado(estado, fecha);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> getPedido(@PathVariable("id") int idPedido)
    {
        return pedidoService.getPedido(idPedido);
    }

    @PostMapping("/save")
    public Pedido save(@RequestBody Pedido pedido)
    {
        return pedidoService.save(pedido);
    }

    @PutMapping("/updateFinalPrice")
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido)
    {
        if(pedidoService.getPedido(pedido.getIdPedido()).isPresent())
        {
            return new ResponseEntity<>(pedidoService.updateFinalPrice(pedido),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updateState")
    public ResponseEntity<Pedido> updateEstado(@RequestBody Pedido pedido)
    {
        if(pedidoService.getPedido(pedido.getIdPedido()).isPresent())
        {
            return new ResponseEntity<>(pedidoService.updateEstado(pedido), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") int idPedido)
    {

        pedidoService.delete(idPedido);
        return true;
    }
}
