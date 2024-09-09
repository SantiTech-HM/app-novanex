package com.Santiago.Novanex.app_NovaNex.repositorios;

import com.Santiago.Novanex.app_NovaNex.Entidadesmodelos.EntidadModeloClientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioClientes extends JpaRepository<EntidadModeloClientes, Integer> {
}
