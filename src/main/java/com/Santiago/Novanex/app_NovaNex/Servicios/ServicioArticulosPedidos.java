//package com.Santiago.Novanex.app_NovaNex.Servicios;
//
//import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.ArticulosPedidos;
//import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
//import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioArticulosPedidos;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class ServicioArticulosPedidos implements IServicioPedidos{
//
//
//    @Autowired
//    private IRepositorioArticulosPedidos iRepositorioArticulosPedidos;
//
//    @Override
//    public List<ArticulosPedidos> listarTodosPedidos() {
//        return iRepositorioArticulosPedidos.findAll();
//    }
//
//    @Override
//    public Pedidos obtenerPedidoPorId(Integer id) {
//        return iRepositorioArticulosPedidos.findById(id);
//    }
//
//    @Override
//    public Pedidos crearPedido(Pedidos pedido) {
//        return null;
//    }
//
//    @Override
//    public Pedidos actualizarPedido(Integer id, Pedidos pedidoObjeto) {
//        return null;
//    }
//
//    @Override
//    public void eliminarPedido(Integer id) {
//
//    }
//
//    @Override
//    public List<Pedidos> obtenerPedidosPorCliente(Integer clienteId) {
//        return List.of();
//    }
//
//    @Override
//    public List<Pedidos> obtenerPedidosPorEstadoPedido(Integer estadoId) {
//        return List.of();
//    }
//
//    @Override
//    public List<Pedidos> obtenerPedidosPorEstadoDevolucion(Integer estadoDevolucionId) {
//        return List.of();
//    }
//
//    @Override
//    public List<Pedidos> obtenerPedidosPorMetodoPago(Integer MetodoPagoId) {
//        return List.of();
//    }
//
//    @Override
//    public List<Pedidos> obtenerPedidosPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
//        return List.of();
//    }
//
//    @Override
//    public Pedidos savePedidos(Pedidos pedido) {
//        return null;
//    }
//
//    @Override
//    public List<ArticulosPedidos> obtenerTodos() {
//        return iRepositorioArticulosPedidos.findAll();
//    }
//
//    @Override
//    public ArticulosPedidos guardar(ArticulosPedidos articulosPedidos) {
//        return iRepositorioArticulosPedidos.save(articulosPedidos);
//    }
//
//    @Override
//    public ArticulosPedidos obtenerPorId(Integer id) {
//        return iRepositorioArticulosPedidos.findById(id).orElseThrow();
//    }
//
//    @Override
//    public void eliminar(Integer id) {
//        iRepositorioArticulosPedidos.deleteById(id);
//    }
//
//    @Override
//    public List<ArticulosPedidos> obtenerPorPedido(Integer pedidoId) {
//        return iRepositorioArticulosPedidos.findByPedidoId(pedidoId);
//    }
//
//    @Override
//    public List<ArticulosPedidos> obtenerPorProducto(Integer productoId) {
//        return iRepositorioArticulosPedidos.findByProductoId(productoId);
//    }
//
//}
