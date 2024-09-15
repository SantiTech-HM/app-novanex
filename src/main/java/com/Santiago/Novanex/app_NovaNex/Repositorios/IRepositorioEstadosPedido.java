package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EstadosPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioEstadosPedido extends JpaRepository <EstadosPedido, Integer> {
}
