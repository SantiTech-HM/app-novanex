package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;

import java.time.LocalDateTime;
import java.util.List;

public interface IServicioPedidos {

    List<Pedidos> listarTodosPedidos();
    Pedidos obtenerPedidoPorId(Integer id);
    Pedidos crearPedido(Pedidos pedido);
    Pedidos actualizarPedido(Integer id, Pedidos pedidoObjeto);

    void eliminarPedido(Integer id);

    List<Pedidos> obtenerPedidosPorCliente(Integer clienteId);
    List<Pedidos> obtenerPedidosPorEstadoPedido(Integer estadoId);
    List<Pedidos>obtenerPedidosPorEstadoDevolucion(Integer estadoDevolucionId);
    List<Pedidos>obtenerPedidosPorMetodoPago(Integer MetodoPagoId);
    List<Pedidos> obtenerPedidosPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);


    Pedidos savePedidos(Pedidos pedido);
}

