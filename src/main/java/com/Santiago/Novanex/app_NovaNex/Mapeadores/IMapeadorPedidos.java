package com.Santiago.Novanex.app_NovaNex.Mapeadores;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;
import org.springframework.stereotype.Component;

@Component
public interface IMapeadorPedidos {

    PedidosDTO convertirADTO(Pedidos pedidos);
    Pedidos convertirAEntidad(PedidosDTO dto);
    void actualizarEntidadDesdeDTO(Pedidos pedido, PedidosDTO dto);
}
