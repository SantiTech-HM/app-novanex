package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.Mapeadores.IMapeadorPedidos;
import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class ServicioPedidos  implements IServicioPedidos{

    private final IRepositorioPedidos iRepositorioPedidos;
    private final IMapeadorPedidos iMapeadorPedidos;

    @Autowired
    public ServicioPedidos(IRepositorioPedidos iRepositorioPedidos, IMapeadorPedidos iMapeadorPedidos) {
        this.iRepositorioPedidos = iRepositorioPedidos;
        this.iMapeadorPedidos = iMapeadorPedidos;
    }

    @Override
    @Transactional
    public PedidosDTO crearPedido(PedidosDTO pedidoDTO) {
        Pedidos pedido = iMapeadorPedidos.convertirAEntidad(pedidoDTO);
        Pedidos pedidoGuardado = iRepositorioPedidos.save(pedido);
        return iMapeadorPedidos.convertirADTO(pedidoGuardado);
    }

    @Override
    @Transactional
    public PedidosDTO actualizarPedido(Integer id, PedidosDTO pedidoDTO) {
        Pedidos pedidoExistente = iRepositorioPedidos.findById(id)
                .orElseThrow(() -> new ExcepcionDePedidos("Pedido no encontrado con id: " + id));

        iMapeadorPedidos.actualizarEntidadDesdeDTO(pedidoExistente, pedidoDTO);
        Pedidos pedidoActualizado = iRepositorioPedidos.save(pedidoExistente);
        return IMapeadorPedidos.convertirADTO(pedidoActualizado);
    }

    @Override
    @Transactional
    public void eliminarPedido(Integer id) {
        if (!IRepositorioPedidos.existsById(id)) {
            throw new ExcepcionDePedidos("Pedido no encontrado con id: " + id);
        }
        iRepositorioPedidos.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PedidosDTO obtenerPedidoPorId(Integer id) {
        Pedidos pedido = iRepositorioPedidos.findById(id)
                .orElseThrow(() -> new ExcepcionDePedidos("Pedido no encontrado con id: " + id));
        return iMapeadorPedidos.convertirADTO(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PedidosDTO> listarTodosPedidos() {
        List<Pedidos> pedidos = iRepositorioPedidos.findAll();
        return pedidos.stream()
                .map(iMapeadorPedidos::convertirADTO)
                .collect(Collectors.toList());
    }
}
