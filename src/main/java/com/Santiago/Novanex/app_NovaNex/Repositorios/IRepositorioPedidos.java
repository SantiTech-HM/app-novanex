package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface IRepositorioPedidos extends JpaRepository<Pedidos, Integer> {



    List<Pedidos> findByClienteId(Integer clienteId);

    List<Pedidos> findByEstadoPedidoId(Integer estadoId);

    List<Pedidos> findByMetodoPagoId(Integer metodoPagoId);

    List<Pedidos> findByEstadoDevolucionId(Integer estadoDevolucionId);

    List<Pedidos> findByFechaCreacionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);








}
