package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;

import java.util.List;


public interface IServicioPedidos {

    PedidosDTO crearPedido(PedidosDTO pedidoDTO);
    PedidosDTO actualizarPedido(Integer id, PedidosDTO pedidoDTO);
    void eliminarPedido(Integer id);
    PedidosDTO obtenerPedidoPorId(Integer id);
    List<PedidosDTO> listarTodosPedidos();
}

