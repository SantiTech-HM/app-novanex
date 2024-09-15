package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.MetodosPago;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioMetodosPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMetodosPago implements IServicioMetodosPago {

    @Autowired
    private IRepositorioMetodosPago iRepositorioMetodosPago;

    @Override
    public List<MetodosPago> listMetodosPago() {
        return iRepositorioMetodosPago.findAll();
    }

    @Override
    public MetodosPago findMetodosPagoById(Integer id) {
        return iRepositorioMetodosPago.findById(id).orElse(null);
    }

    @Override
    public MetodosPago saveMetodosPago(MetodosPago metodosPago) {
        return iRepositorioMetodosPago.save(metodosPago);
    }

    @Override
    public void deleteMetodosPago(MetodosPago metodosPago) {
            iRepositorioMetodosPago.delete(metodosPago);
    }
}
