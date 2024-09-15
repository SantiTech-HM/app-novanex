package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EstadosPedido;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioEstadosPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioEstadosPedido implements IServicioEstadosPedido {

   @Autowired
   private IRepositorioEstadosPedido iRepositorioEstadosPedido;

    @Override
    public List<EstadosPedido> listEstadosPedido() {
        return iRepositorioEstadosPedido.findAll();
    }

    @Override
    public EstadosPedido findEstadosPedidoById(Integer id) {
        return iRepositorioEstadosPedido.findById(id).orElse(null);
    }

    @Override
    public EstadosPedido saveEstadosPedido(EstadosPedido estadosPedido) {
        return iRepositorioEstadosPedido.save(estadosPedido);
    }

    @Override
    public void deleteEstadosPedido(EstadosPedido estadosPedido) {
        iRepositorioEstadosPedido.delete(estadosPedido);
    }
}
