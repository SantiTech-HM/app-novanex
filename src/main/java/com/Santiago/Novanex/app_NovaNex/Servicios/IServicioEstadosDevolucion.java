package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EstadosDevolucion;

import java.util.List;

public interface IServicioEstadosDevolucion {


    public List<EstadosDevolucion> listEstadosDevolucion();

    public EstadosDevolucion findEstadosDevolucionById(Integer id);

    public EstadosDevolucion saveEstadosDevolucion (EstadosDevolucion estadosDevolucion);

    public void  deleteEstadosDevolucion (EstadosDevolucion estadosDevolucion);
}
