package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EntidadClientes;

import java.util.List;

public interface IServicioClientes {

    public List<EntidadClientes> listEntidadClientes();

    public EntidadClientes findEntidadClientesById(Integer id);

    public EntidadClientes saveEntidadClientes (EntidadClientes entidadClientes);

    public void  deleteEntidadClientes (EntidadClientes  entidadClientes);


}
