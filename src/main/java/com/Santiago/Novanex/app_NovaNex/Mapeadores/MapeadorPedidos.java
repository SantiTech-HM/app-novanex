package com.Santiago.Novanex.app_NovaNex.Mapeadores;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.*;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IReposirorioEstadosDevolucion;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioClientes;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioEstadosPedido;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioMetodosPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapeadorPedidos implements IMapeadorPedidos{

    @Autowired
    private IRepositorioClientes iRepositorioClientes;

    @Autowired
    private IRepositorioEstadosPedido iRepositorioEstadosPedido;

    @Autowired
    private IReposirorioEstadosDevolucion iReposirorioEstadosDevolucion;

    @Autowired
    private IRepositorioMetodosPago iRepositorioMetodosPago;

    @Override
    public PedidosDTO convertirADTO(Pedidos pedido) {
        PedidosDTO dto = new PedidosDTO();
        dto.setId(pedido.getId());
        dto.setClienteId(pedido.getClientes().getId());
        dto.setEstadoId(pedido.getEstadosPedido().getId());
        if (pedido.getEstadoDevolucion() != null) {
            dto.setEstadoDevolucionId(pedido.getEstadoDevolucion().getId());
        }
        dto.setMetodoPagoId(pedido.getMetodoPago().getId());
        dto.setPrecioTotal(pedido.getPrecioTotal());
        dto.setFechaCreacion(pedido.getFechaCreacion());
        return dto;
    }

    @Override
    public Pedidos convertirAEntidad(PedidosDTO dto) {
        if (dto == null) {
            return null;
        }

        Pedidos pedido = new Pedidos();
        actualizarEntidadDesdeDTO(pedido, dto);
        return pedido;
    }


    @Override
    public void actualizarEntidadDesdeDTO(Pedidos pedido, PedidosDTO dto) {
        if (pedido == null || dto == null) {
            throw new ExcepcionDePedidos("Pedido o DTO no pueden ser null");
        }


        pedido.setPrecioTotal(dto.getPrecioTotal());
        pedido.setFechaCreacion(dto.getFechaCreacion());

        if (dto.getClienteId() != null) {
            Clientes cliente = iRepositorioClientes.findById(dto.getClienteId())
                    .orElseThrow(() -> new ExcepcionDePedidos("Cliente no encontrado con ID: " + dto.getClienteId()));
            pedido.setClientes(cliente);
        }

        if (dto.getEstadoId() != null) {
            EstadosPedido estadosPedido = iRepositorioEstadosPedido.findById(dto.getEstadoId())
                    .orElseThrow(() -> new ExcepcionDePedidos("Estado del pedido no encontrado con ID: " + dto.getEstadoId()));
            pedido.setEstadosPedido(estadosPedido);
        }

        if (dto.getEstadoDevolucionId() != null) {
            EstadosDevolucion estadosDevolucion = iReposirorioEstadosDevolucion.findById(dto.getEstadoDevolucionId())
                    .orElseThrow(() -> new ExcepcionDePedidos("Estado de Devolucion no encontrado con ID: " + dto.getEstadoDevolucionId()));
            pedido.setEstadosDevolucion(estadosDevolucion);
        } else {
            pedido.setEstadosDevolucion(null);
        }

        if (dto.getMetodoPagoId() != null) {
            MetodosPago metodosPago = iRepositorioMetodosPago.findById(dto.getMetodoPagoId())
                    .orElseThrow(() -> new ExcepcionDePedidos("Metodo de Pago no encontrado con ID: " + dto.getMetodoPagoId()));
            pedido.setMetodosPago(metodosPago);
        }
    }

}
