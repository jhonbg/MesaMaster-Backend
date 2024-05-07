package com.laempacadora.domain.service;

import com.laempacadora.persistence.DetallePedidoRepository;
import com.laempacadora.persistence.entity.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> getAll()
    {
        return detallePedidoRepository.getAll();
    }

    public List<DetallePedido> getPedido(int idPedido)
    {
        return detallePedidoRepository.getPedido(idPedido);
    }

    public Optional<DetallePedido> getDetallePedido(int idDetallePedido)
    {
        return detallePedidoRepository.getDetallePedido(idDetallePedido);
    }

    public boolean delete(int idDetallePedido)
    {
        return getDetallePedido(idDetallePedido).map(detallePedido -> {
            detallePedidoRepository.delete(idDetallePedido);
            return true;
        }).orElse(false);
    }

    public DetallePedido save(DetallePedido detallePedido)
    {
        return detallePedidoRepository.save(detallePedido);
    }

    public boolean exists(int idDetalleProducto)
    {
        boolean existe = false;
        if(detallePedidoRepository.getDetallePedido(idDetalleProducto).isPresent())
        {
            existe = true;
        }
        return existe;
    }

    public DetallePedido update(DetallePedido detallePedido)
    {
        return detallePedidoRepository.update(detallePedido);
    }
}
