//package com.Santiago.Novanex.app_NovaNex.Controladores;
//
//import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.ArticulosPedidos;
//import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioArticulosPedidos;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v8/")
//@CrossOrigin(value = "http://localhost:4200")
//public class ControladorArticulosPedidos {
//
//    @Autowired
//    private IServicioArticulosPedidos iServicioArticulosPedidos;
//
//    @GetMapping
//    public List<ArticulosPedidos> obtenerTodos() {
//        return iServicioArticulosPedidos.obtenerTodos();
//    }
//
//    @PostMapping
//    public ArticulosPedidos guardar(@RequestBody ArticulosPedidos articulosPedidos) {
//        return iServicioArticulosPedidos.guardar(articulosPedidos);
//    }
//
//    @GetMapping("/{id}")
//    public ArticulosPedidos obtenerPorId(@PathVariable Integer id) {
//        return iServicioArticulosPedidos.obtenerPorId(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void eliminar(@PathVariable Integer id) {
//        iServicioArticulosPedidos.eliminar(id);
//    }
//
//    @GetMapping(value = "/pedido/{pedidoId}")
//    public List<ArticulosPedidos> obtenerPorPedido(@PathVariable Integer pedidoId) {
//        return iServicioArticulosPedidos.obtenerPorPedido(pedidoId);
//    }
//
//    @GetMapping(value = "/producto/{productoId}")
//    public List<ArticulosPedidos> obtenerPorProducto(@PathVariable Integer productoId) {
//        return iServicioArticulosPedidos.obtenerPorProducto(productoId);
//    }
//}
