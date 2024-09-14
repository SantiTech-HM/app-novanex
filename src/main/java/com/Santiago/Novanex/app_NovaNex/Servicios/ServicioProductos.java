package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Productos;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioProductos implements IServicioProductos{

    @Autowired
    private IRepositorioProductos iRepositorioProductos;

    @Override
    public List<Productos> listProductos() {
        return iRepositorioProductos.findAll();
    }

    @Override
    public Productos findProductosById(Integer id) {
        return iRepositorioProductos.findById(id).orElse(null);
    }

    @Override
    public Productos saveProductos(Productos productos) {
        return iRepositorioProductos.save(productos);
    }

    @Override
    public void deleteProductos(Productos productos) {
    iRepositorioProductos.delete(productos);
    }
}
