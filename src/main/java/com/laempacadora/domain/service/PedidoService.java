package com.laempacadora.domain.service;

import com.laempacadora.domain.EstadoPedido;
import com.laempacadora.persistence.PedidoRepository;
import com.laempacadora.persistence.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAll()
    {
        return pedidoRepository.getAll();
    }

    public List<Pedido> getPedidoEstado(EstadoPedido estdoPedido, LocalDate fecha)
    {
        return pedidoRepository.getPedidoEstado(estdoPedido, fecha);
    }

    public Optional<Pedido> getPedido(int idPedido)
    {
        return pedidoRepository.getPedido(idPedido);
    }

    public Boolean exists(int idPedido)
    {
        boolean existe = false;
        if(pedidoRepository.getPedido(idPedido).isPresent() == false)
        {
            existe = true;
        }
        return existe;
    }

    public Pedido save(Pedido pedido)
    {
        return pedidoRepository.save(pedido);
    }

    public Pedido update(Pedido pedido)
    {
        return pedidoRepository.save(pedido);
    }

    public Boolean delete(int idPedido)
    {
        return getPedido(idPedido).map(pedido -> {
            pedidoRepository.delete(idPedido);
            return true;
        }).orElse(false);
    }

    public Pedido updateFinalPrice(Pedido pedido)
    {
        return pedidoRepository.updateFinalPrice(pedido);
    }

    public Pedido updateEstado(Pedido pedido)
    {
        return pedidoRepository.updateEstado(pedido);
    }
}
