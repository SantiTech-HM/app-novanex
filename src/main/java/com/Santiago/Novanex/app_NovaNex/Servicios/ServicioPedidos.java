package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
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
        return List.of();
    }

    @Override
    public Pedidos findPedidosById(Integer id) {
        return null;
    }

    @Override
    public Pedidos savePedidos(Pedidos pedido) {
        return null;
    }

    @Override
    public void deletePedidos(Integer id) {

    }

    @Override
    public List<Pedidos> getPedidosPorCliente(Integer clienteId) {
        return List.of();
    }

    @Override
    public List<Pedidos> getPedidosPorEstado(Integer estadoId) {
        return List.of();
    }

    @Override
    public List<Pedidos> getPedidosPorEstadoDevolucion(Integer estadoDevolucionId) {
        return List.of();
    }

    @Override
    public List<Pedidos> getPedidosPorMetodoPago(Integer metodoPagoId) {
        return List.of();
    }

    @Override
    public List<Pedidos> getPedidosPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return List.of();
    }
}
