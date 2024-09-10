package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EntidadClientes;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioClientes {

    @Autowired
    private IRepositorioClientes iRepositorioClientes;

    public Iterable<EntidadClientes> findAll(){
        return iRepositorioClientes.findAll();
    }
    public EntidadClientes findById(Integer id){
        return iRepositorioClientes.findById(id).orElse(null);
    }

    public EntidadClientes crear(EntidadClientes entidadClientes){
        entidadClientes.setcrear(entidadClientes.localDate.now());
        return iRepositorioClientes.save(entidadClientes);
    }
    public EntidadClientes actualizar(Integer id, EntidadClientes form){
    
    }
}
