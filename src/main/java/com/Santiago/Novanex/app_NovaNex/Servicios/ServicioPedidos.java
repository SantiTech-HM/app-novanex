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
    public List<Pedidos> listPedidos() {
        return iRepositorioPedidos.findAll();
    }

    @Override
    public Pedidos findPedidosById(Integer id) {
        return iRepositorioPedidos.findById(id)
                .orElseThrow(() -> new ExcepcionDePedidos("No se encontró el pedido con id: " + id));
    }

    @Override
    public Pedidos savePedidos(Pedidos pedidos) {
        pedidos.setFechaCreacion(LocalDateTime.now());
        return iRepositorioPedidos.save(pedidos);
    }

    @Override
    public Pedidos updatePedidos(Integer id, Pedidos pedidosDetails) {
    Pedidos pedidos = findPedidosById(id);
        pedidos.setClientes(pedidosDetails.getClientes());
        pedidos.setEstadosPedido(pedidosDetails.getEstadosPedido());
        pedidos.setEstadosDevolucion(pedidosDetails.getEstadosDevolucion());
        pedidos.setMetodoPago(pedidosDetails.getMetodoPago());
        pedidos.setPrecioTotal(pedidosDetails.getPrecioTotal());
        pedidos.setFechaCreacion(pedidosDetails.getFechaCreacion());
        return iRepositorioPedidos.save(pedidos);
    }

    @Override
    public void deletePedidos(Integer id) {
        Pedidos pedidos = findPedidosById(id);
        iRepositorioPedidos.delete(pedidos);
    }

    @Override
    public List<Pedidos> findPedidosPorCliente(Integer clienteId) {
        return iRepositorioPedidos.findByClienteId(clienteId);
    }

    @Override
    public List<Pedidos> findPedidosPorEstado(Integer estadoId) {
        return iRepositorioPedidos.findByEstadoId(estadoId);
    }

    @Override
    public List<Pedidos> findPedidosPorEstadoDevolucion(Integer estadoDevolucionId) {
        return iRepositorioPedidos.findByEstadoDevolucionId(estadoDevolucionId);
    }

    @Override
    public List<Pedidos> findPedidosPorMetodoPago(Integer metodoPagoId) {
        return iRepositorioPedidos.findByMetodoPagoId(metodoPagoId);
    }

    @Override
    public List<Pedidos> findPedidosPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return iRepositorioPedidos.findByFechaCreacionBetween(inicio, fin);
    }
}
