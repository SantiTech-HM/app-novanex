package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioPedidos implements IServicioPedidos {

    @Autowired
    private IRepositorioPedidos iRepositorioPedidos;

    @Override
    public Pedidos savePedido(Pedidos pedido) {

        if (pedido.getPrecioTotal() == null || pedido.getPrecioTotal() <= 0) {
            throw new ExcepcionDePedidos("El precio total debe ser mayor a cero.");
        }
        pedido.setFechaCreacion(LocalDateTime.now());
        return iRepositorioPedidos.save(pedido);
    }

    @Override
    public Pedidos updatePedido(Pedidos pedido) {
        return null;
    }

    @Override
    public Optional<Pedidos> findPedidoById(Integer id) {
        return iRepositorioPedidos.findById(id);
    }

    @Override
    public List<Pedidos> findAllPedidos() {
        return iRepositorioPedidos.findAll();
    }

    @Override
    public void deletePedido(Integer id) {
        if (!iRepositorioPedidos.existsById(id)) {
            throw new ExcepcionDePedidos("Pedido no encontrado con ID: " + id);
        }
        iRepositorioPedidos.deleteById(id);
    }
}
