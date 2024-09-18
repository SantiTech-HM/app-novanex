package com.Santiago.Novanex.app_NovaNex.Mapeadores;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapeadorPedidos {

    MapeadorPedidos INSTANCE = Mappers.getMapper(MapeadorPedidos.class);

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "estado.id", target = "estadoId")
    @Mapping(source = "estadoDevolucion.id", target = "estadoDevolucionId")
    @Mapping(source = "metodo_Pago_id", target = "metodoPagoId")
    PedidosDTO aDTO(Pedidos pedido);

    @Mapping(source = "clienteId", target = "cliente.id")
    @Mapping(source = "estadoId", target = "estado.id")
    @Mapping(source = "estadoDevolucionId", target = "estadoDevolucion.id")
    @Mapping(source = "metodoPagoId", target = "metodoPago.id")
    Pedidos aEntity(PedidosDTO pedidoDTO);
}
