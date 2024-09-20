package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface IRepositorioPedidos extends JpaRepository<Pedidos, Integer> {



//    public List<Pedidos> findByClienteId(Integer clienteId);
//
//    public List<Pedidos> findByEstadoPedidoId(Integer estadoId);
//
//    public List<Pedidos> findByMetodoPagoId(Integer metodoPagoId);
//
//    public List<Pedidos> findByEstadoDevolucionId(Integer estadoDevolucionId);
//
//    public List<Pedidos> findByFechaCreacionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);


}
