package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface IRepositorioPedidos extends JpaRepository<Pedidos, Integer> {


    List<Pedidos> findByClienteId(Integer clienteId);


    List<Pedidos> findByEstadoId(Integer estadoId);


    List<Pedidos> findByMetodoPagoId(Integer metodoPagoId);


    List<Pedidos> findByFechaCreacionBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);


    List<Pedidos> findByPrecioTotalGreaterThan(Double precioMinimo);


    @Query("SELECT p.estado.id, COUNT(p) FROM Pedidos p GROUP BY p.estado.id")
    List<Object[]> countPedidosPorEstado();


    List<Pedidos> findByClienteIdAndEstadoId(Integer clienteId, Integer estadoId);


    @Query("SELECT p FROM Pedidos p ORDER BY p.fechaCreacion DESC")
    List<Pedidos> findLastNPedidos(@Param("limit") int limit);


    List<Pedidos> findfindfindByEstadoDevolucionIdIsNotNull();


    @Query("SELECT SUM(p.precioTotal) FROM Pedidos p WHERE p.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    Double calcularTotalVentasEnPeriodo(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

}
