package com.laempacadora.persistence.crud;

import com.laempacadora.domain.EstadoPedido;
import com.laempacadora.persistence.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PedidoCrudRepository extends CrudRepository<Pedido,Integer> {
    @Query("SELECT  p FROM Pedido  p WHERE p.estadoPedido = :estado AND DATE(p.fechaInicial) = :fecha")
    List<Pedido> findPedidoByEstadoPedidoAndFechaInicialWithoutTime(@Param(("estado")) EstadoPedido estadoPedido, @Param("fecha") LocalDate fecha);
}
