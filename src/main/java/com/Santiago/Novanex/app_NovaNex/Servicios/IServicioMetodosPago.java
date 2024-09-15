package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.MetodosPago;

import java.util.List;

public interface IServicioMetodosPago {

    public List<MetodosPago> listMetodosPago();

    public MetodosPago findMetodosPagoById(Integer id);

    public MetodosPago saveMetodosPago (MetodosPago metodosPago);

    public void  deleteMetodosPago (MetodosPago metodosPago);
}
