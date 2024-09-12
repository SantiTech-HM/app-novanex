package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Clientes;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioClientes  implements IServicioClientes{

    @Autowired
    private IRepositorioClientes iRepositorioClientes;

    @Override
    public List<Clientes> listClientes() {
        return iRepositorioClientes.findAll();
    }

    @Override
    public Clientes findClientesById(Integer id) {
        return iRepositorioClientes.findById(id).orElse(null);
    }

    @Override
    public Clientes saveClientes(Clientes clientes) {
        return iRepositorioClientes.save(clientes);
    }

    @Override
    public void deleteClientes(Clientes clientes) {
        iRepositorioClientes.delete(clientes);
    }
}
