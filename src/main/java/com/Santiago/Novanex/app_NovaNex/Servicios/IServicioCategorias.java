package com.Santiago.Novanex.app_NovaNex.Servicios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Categorias;


import java.util.List;

public interface IServicioCategorias {

    public List<Categorias> listCategorias();

    public Categorias findCategoriasById(Integer id);

    public Categorias saveCategorias (Categorias categorias);

    public void  deleteCategorias (Categorias categorias);
}
