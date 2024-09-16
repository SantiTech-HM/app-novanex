package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;

import java.time.LocalDateTime;
import java.util.List;

public interface IServicioPedidos {

    public List<Pedidos> listPedidos();
    public Pedidos findPedidosById(Integer id);
    public Pedidos savePedidos(Pedidos pedido);
    public Pedidos updatePedidos(Integer id, Pedidos pedidosDetails);
    public void deletePedidos(Integer id);



    public List<Pedidos> findPedidosPorCliente(Integer clienteId);
    public List<Pedidos> findPedidosPorEstado(Integer estadoId);
    public List<Pedidos> findPedidosPorEstadoDevolucion(Integer estadoDevolucionId);
    public List<Pedidos> findPedidosPorMetodoPago(Integer metodoPagoId);
    public List<Pedidos> findPedidosPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);

}
