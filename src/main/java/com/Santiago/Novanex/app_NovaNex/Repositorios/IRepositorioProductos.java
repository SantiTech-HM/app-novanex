package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioProductos extends JpaRepository <Productos, Integer> {
}
