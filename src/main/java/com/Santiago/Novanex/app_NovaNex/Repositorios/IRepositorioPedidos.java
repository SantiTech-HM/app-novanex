package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IRepositorioPedidos extends JpaRepository<Pedidos, Integer> {

    List<Pedidos> findByClientesId(Integer clienteId);
    List<Pedidos> findByEstadosPedidoId(Integer estadoId);
    List<Pedidos> findByEstadosDevolucionId(Integer estadoDevolucionId);
    List<Pedidos> findByMetodosPagoId(Integer metodoPagoId);
    List<Pedidos> findByFechaCreacionBetween(LocalDateTime inicio, LocalDateTime fin);
}
