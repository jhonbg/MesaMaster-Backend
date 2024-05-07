package com.laempacadora.persistence;

import com.laempacadora.persistence.crud.DetallePedidoCrudRepository;
import com.laempacadora.persistence.entity.DetallePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DetallePedidoRepository {
    @Autowired
    private DetallePedidoCrudRepository detallePedidoCrudRepository;

    public List<DetallePedido> getAll()
    {
        return (List<DetallePedido>) detallePedidoCrudRepository.findAll();
    }

    public List<DetallePedido> getPedido(int idPedido)
    {
        return (List<DetallePedido>) detallePedidoCrudRepository.findAllByIdPedido(idPedido);
    }

    public Optional<DetallePedido> getDetallePedido(int idDetallePedido)
    {
        return detallePedidoCrudRepository.findById(idDetallePedido);
    }

    public DetallePedido save(DetallePedido detallePedido)
    {
        return detallePedidoCrudRepository.save(detallePedido);
    }

    public void delete(int idDetallePedido)
    {
        detallePedidoCrudRepository.deleteById(idDetallePedido);
    }

    public DetallePedido update(DetallePedido detallePedido)
    {
        return detallePedidoCrudRepository.save(detallePedido);
    }
}
