package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EstadosDevolucion;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IReposirorioEstadosDevolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEstadosDevolucion implements IServicioEstadosDevolucion{


    @Autowired
    private IReposirorioEstadosDevolucion iReposirorioEstadosDevolucion;

    @Override
    public List<EstadosDevolucion> listEstadosDevolucion() {
        return iReposirorioEstadosDevolucion.findAll();
    }

    @Override
    public EstadosDevolucion findEstadosDevolucionById(Integer id) {
        return iReposirorioEstadosDevolucion.findById(id).orElse(null);
    }

    @Override
    public EstadosDevolucion saveEstadosDevolucion(EstadosDevolucion estadosDevolucion) {
        return iReposirorioEstadosDevolucion.save(estadosDevolucion);
    }

    @Override
    public void deleteEstadosDevolucion(EstadosDevolucion estadosDevolucion) {
        iReposirorioEstadosDevolucion.delete(estadosDevolucion);
    }
}
