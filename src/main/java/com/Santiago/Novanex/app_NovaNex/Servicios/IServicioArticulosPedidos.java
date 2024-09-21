package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.ArticulosPedidos;
import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Productos;

import java.util.List;

public interface IServicioArticulosPedidos {

    List<ArticulosPedidos> listarTodosLosArticulosPedidos();
    ArticulosPedidos obtenerArticuloPedidoPorId(Integer id);
    ArticulosPedidos crearArticuloPedido(ArticulosPedidos articulosPedidos);
    ArticulosPedidos actualizarArticulosPedidos(Integer id, ArticulosPedidos articulosPedidosObjeto);

    void eliminarArticuloPedido(Integer id);

    List<ArticulosPedidos> obtenerArticulosPedidosPorPedido(Pedidos pedidoId);
    List<ArticulosPedidos> obtenerArticulosPedidosPorProducto(Productos productoId);
    ArticulosPedidos saveArticulosPedidos(ArticulosPedidos articulosPedidos);
}
