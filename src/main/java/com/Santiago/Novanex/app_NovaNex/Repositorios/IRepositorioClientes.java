package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EntidadClientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioClientes extends JpaRepository<EntidadClientes, Integer> {
}
