package com.Santiago.Novanex.app_NovaNex.Repositorios;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.ArticulosPedidos;
import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositorioArticulosPedidos extends JpaRepository<ArticulosPedidos, Integer>{

    List<Pedidos> findByPedidoId(Integer pedidoId);
    List<Pedidos> findByProductoId(Integer productoId);
}
