package com.Santiago.Novanex.app_NovaNex.Servicios;



import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EstadosPedido;

import java.util.List;

public interface IServicioEstadosPedido {

        public List<EstadosPedido> listEstadosPedido();

        public EstadosPedido findEstadosPedidoById(Integer id);

        public EstadosPedido saveEstadosPedido (EstadosPedido estadosPedido);

        public void  deleteEstadosPedido (EstadosPedido estadosPedido);
}
