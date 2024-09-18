package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;

import java.util.List;
import java.util.Optional;

public interface IServicioPedidos {

    public Pedidos savePedido(Pedidos pedido);
    public Pedidos updatePedido(Integer id);
    public Optional<Pedidos> findPedidoById(Integer id);
    public List<Pedidos> findAllPedidos();
    public void deletePedido(Integer id);
}

