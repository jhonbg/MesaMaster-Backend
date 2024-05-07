package com.laempacadora.persistence.crud;

import com.laempacadora.persistence.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoCrudRepository extends CrudRepository<Pedido,Integer> {
}
