package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioPedidos implements IServicioPedidos{


    @Autowired
    private IRepositorioPedidos iRepositorioPedidos;

    @Override
    public List<Pedidos> listarTodosPedidos() {
        return iRepositorioPedidos.findAll();
    }

    @Override
    public Pedidos obtenerPedidoPorId(Integer id) {
        return iRepositorioPedidos.findById(id)
                .orElseThrow(() -> new ExcepcionDePedidos("No se encontró el pedido con id: " + id));
    }

    @Override
    public Pedidos crearPedido(Pedidos pedido) {
        pedido.setFechaCreacion(LocalDateTime.now());
        return iRepositorioPedidos.save(pedido);
    }

    @Override
    public Pedidos actualizarPedido(Integer id, Pedidos pedidoDetails) {
        Pedidos pedido = obtenerPedidoPorId(id);
        pedido.setCliente(pedidoDetails.getCliente());
        pedido.setEstadoPedido(pedidoDetails.getEstadoPedido());
        pedido.setEstadoDevolucion(pedidoDetails.getEstadoDevolucion());
        pedido.setMetodoPago(pedidoDetails.getMetodoPago());
        pedido.setPrecioTotal(pedidoDetails.getPrecioTotal());
        return iRepositorioPedidos.save(pedido);
    }

    @Override
    public Pedidos savePedidos(Pedidos pedido) {
        return iRepositorioPedidos.save(pedido);
    }

    @Override
    public void eliminarPedido(Integer id) {
        Pedidos pedido = obtenerPedidoPorId(id);
        iRepositorioPedidos.delete(pedido);
    }

    @Override
    public List<Pedidos> obtenerPedidosPorCliente(Integer clienteId) {
        return iRepositorioPedidos.findByClienteId(clienteId);
    }

    @Override
    public List<Pedidos> obtenerPedidosPorEstadoPedido(Integer estadoId) {
        return iRepositorioPedidos.findByEstadoPedidoId(estadoId);
    }

    @Override
    public List<Pedidos>obtenerPedidosPorEstadoDevolucion(Integer estadoDevolucionId) {
        return iRepositorioPedidos.findByEstadoDevolucionId(estadoDevolucionId);
    }

@Override
    public List<Pedidos>obtenerPedidosPorMetodoPago(Integer metodoPagoId) {
        return iRepositorioPedidos.findByMetodoPagoId(metodoPagoId);
    }

    @Override
    public List<Pedidos> obtenerPedidosPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return iRepositorioPedidos.findByFechaCreacionBetween(inicio, fin);
    }


}
