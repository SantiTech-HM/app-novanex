package com.Santiago.Novanex.app_NovaNex.Servicios;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Categorias;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCategorias implements IServicioCategorias{


    @Autowired
    private IRepositorioCategorias iRepositorioCategorias;


    @Override
    public List<Categorias> listCategorias() {
        return iRepositorioCategorias.findAll();
    }

    @Override
    public Categorias findCategoriasById(Integer id) {
        return iRepositorioCategorias.findById(id).orElse(null);
    }

    @Override
    public Categorias saveCategorias(Categorias categorias) {
        return iRepositorioCategorias.save(categorias);
    }

    @Override
    public void deleteCategorias(Categorias categorias) {
        iRepositorioCategorias.delete(categorias);
    }
}
