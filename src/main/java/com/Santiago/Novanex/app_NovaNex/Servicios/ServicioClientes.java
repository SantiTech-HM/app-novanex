package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EntidadClientes;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioClientes  implements IServicioClientes{

    @Autowired
    private IRepositorioClientes iRepositorioClientes;

    @Override
    public List<EntidadClientes> listEntidadClientes() {
        return iRepositorioClientes.findAll();

    }
    @Override
    public EntidadClientes findEntidadClietesById(Integer id) {
        return iRepositorioClientes.findById(id).orElse(null);

    }
    @Override
    public EntidadClientes saveEntidadClietes(EntidadClientes entidadClientes){
        return iRepositorioClientes.save(entidadClientes);

    }
    @Override
    public EntidadClientes deleteEntidadClietes(EntidadClientes entidadClientes){
        iRepositorioClientes.delete(entidadClientes);
    }
}
