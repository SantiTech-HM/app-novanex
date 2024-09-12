package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Clientes;

import java.util.List;

public interface IServicioClientes {

    public List<Clientes> listClientes();

    public Clientes findClientesById(Integer id);

    public Clientes saveClientes (Clientes clientes);

    public void  deleteClientes (Clientes clientes);


}
