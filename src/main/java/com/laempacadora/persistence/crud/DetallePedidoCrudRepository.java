package com.laempacadora.persistence.crud;

import com.laempacadora.persistence.entity.DetallePedido;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DetallePedidoCrudRepository extends CrudRepository<DetallePedido, Integer> {
    List<DetallePedido> findAllByIdPedido(Integer idPedido);
}
