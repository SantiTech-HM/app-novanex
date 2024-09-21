package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.ArticulosPedidos;
import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioArticulosPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServicioArticulosPedidos implements IServicioPedidos{


    @Autowired
    private IRepositorioArticulosPedidos iRepositorioArticulosPedidos;


    @Override
    public List<Pedidos> listarTodosPedidos() {
        return List.of();
    }

    @Override
    public Pedidos obtenerPedidoPorId(Integer id) {
        return null;
    }

    @Override
    public Pedidos crearPedido(Pedidos pedido) {
        return null;
    }

    @Override
    public Pedidos actualizarPedido(Integer id, Pedidos pedidoObjeto) {
        return null;
    }

    @Override
    public void eliminarPedido(Integer id) {

    }
    @Override
    public Pedidos savePedidos(Pedidos pedido) {
        return null;
    }

    @Override
    public List<ArticulosPedidos> obtenerArticulosPedidosPorPedido(Integer pedidoId) {
        return iRepositorioArticulosPedidos.findByPedidoId(pedidoId);
    }

    @Override
    public List<ArticulosPedidos> obtenerArticulosPedidosPorProducto(Integer productoId) {
        return iRepositorioArticulosPedidos.findByProductoId(productoId);
    }

}
