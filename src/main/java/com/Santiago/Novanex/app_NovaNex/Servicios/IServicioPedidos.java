package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;

import java.time.LocalDateTime;
import java.util.List;

public interface IServicioPedidos {

    public List<Pedidos> listPedidos();
    public Pedidos findPedidosById(Integer id);
    public Pedidos savePedidos(Pedidos pedido);
    //public Pedidos updatePedidos(Integer id, Pedidos pedidoDetails);
    public void deletePedidos(Integer id);



    public List<Pedidos> getPedidosPorCliente(Integer clienteId);
    public List<Pedidos> getPedidosPorEstado(Integer estadoId);
    public List<Pedidos> getPedidosPorEstadoDevolucion(Integer estadoDevolucionId);
    public List<Pedidos> getPedidosPorMetodoPago(Integer metodoPagoId);
    public List<Pedidos> getPedidosPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);

}
