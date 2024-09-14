package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Productos;

import java.util.List;

public interface IServicioProductos {

    public List<Productos> listProductos();

    public Productos findProductosById(Integer id);

    public Productos saveProductos (Productos productos);

    public void  deleteProductos (Productos productos);
}
