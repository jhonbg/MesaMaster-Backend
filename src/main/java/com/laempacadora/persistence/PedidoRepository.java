package com.laempacadora.persistence;

import com.laempacadora.domain.EstadoPedido;
import com.laempacadora.persistence.crud.PedidoCrudRepository;
import com.laempacadora.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepository {
    @Autowired
    private PedidoCrudRepository pedidoCrudRepository;

    public List<Pedido> getAll()
    {
        return (List<Pedido>) pedidoCrudRepository.findAll();
    }

    public List<Pedido> getPedidoEstado(EstadoPedido estadoPedido, LocalDate fecha)
        {
            return pedidoCrudRepository.findPedidoByEstadoPedidoAndFechaInicialWithoutTime(estadoPedido, fecha);
        }

    public Optional<Pedido> getPedido(int idPedido)
    {
        return pedidoCrudRepository.findById(idPedido);
    }

    public Pedido save(Pedido pedido)
    {
        return pedidoCrudRepository.save(pedido);
    }

    public void delete(int idPedido)
    {
        pedidoCrudRepository.deleteById(idPedido);
    }

    public Pedido updateEstado(Pedido pedido)
    {
        Optional<Pedido> existingPedidoOptional = getPedido(pedido.getIdPedido());
        if(existingPedidoOptional.isPresent())
        {
            Pedido existingPedido = existingPedidoOptional.get();
            existingPedido.setEstadoPedido(pedido.getEstadoPedido());
            return pedidoCrudRepository.save(existingPedido);
        }
        return null;
    }

    public Pedido updateFinalPrice(Pedido pedido)
    {
        Optional<Pedido> existingPedidoOptinal = getPedido(pedido.getIdPedido());
        if(existingPedidoOptinal.isPresent())
        {
            Pedido existingPedido = existingPedidoOptinal.get();
            existingPedido.setPrecioFinal(pedido.getPrecioFinal());
            return pedidoCrudRepository.save(existingPedido);
        }
        return null;
    }
}
