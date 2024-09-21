package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;

import java.util.List;


public interface IServicioPedidos {
// un comentario
    public PedidosDTO crearPedido(PedidosDTO pedidoDTO);
    public PedidosDTO actualizarPedido(Integer id, PedidosDTO pedidoDTO);
    public void eliminarPedido(Integer id);
    public PedidosDTO obtenerPedidoPorId(Integer id);
    public List<PedidosDTO> listarTodosPedidos();
}

