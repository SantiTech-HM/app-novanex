package com.Santiago.Novanex.app_NovaNex.Mapeadores;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Clientes;
import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;
import org.springframework.stereotype.Component;

@Component
public interface IMapeadorPedidos {

    public PedidosDTO convertirADTO(Pedidos pedidos, Clientes clientes);
    public Pedidos convertirAEntidad(PedidosDTO dto);
    public void actualizarEntidadDesdeDTO(Pedidos pedido, PedidosDTO dto);
}
