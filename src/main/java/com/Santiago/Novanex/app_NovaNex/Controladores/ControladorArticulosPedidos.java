package com.Santiago.Novanex.app_NovaNex.Controladores;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.ArticulosPedidos;
import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioArticulosPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v8/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorArticulosPedidos {

    @Autowired
    private IServicioArticulosPedidos iServicioArticulosPedidos;

    @GetMapping("articulospedidos")
    public List<ArticulosPedidos> obtenerTodosLosArticulosPedidos() {
        return iServicioArticulosPedidos.listarTodosLosArticulosPedidos();
    }

    @GetMapping("articulopedido/{id}")
    public ResponseEntity<ArticulosPedidos> obtenerArticuloPedidoPorId(@PathVariable Integer id) {
        ArticulosPedidos articuloPedido = iServicioArticulosPedidos.obtenerArticuloPedidoPorId(id);
        return ResponseEntity.ok(articuloPedido);
    }

    @PostMapping("articulopedido")
    public ResponseEntity<ArticulosPedidos> crearArticuloPedido(@RequestBody ArticulosPedidos articuloPedido) {
        ArticulosPedidos nuevoArticuloPedido = iServicioArticulosPedidos.crearArticuloPedido(articuloPedido);
        return ResponseEntity.ok(nuevoArticuloPedido);
    }

    @PutMapping("articulospedidos/{id}")

    public ResponseEntity<ArticulosPedidos> actualizarArticulosPedidos(@PathVariable Integer id, @RequestBody ArticulosPedidos articulosPedidosObjeto) {

        ArticulosPedidos articulosPedidos = iServicioArticulosPedidos.actualizarArticulosPedidos(id, articulosPedidosObjeto);
        if (articulosPedidos == null){
            throw new ExcepcionDePedidos("ID del pedido no encontrado:" + id);
        }
        articulosPedidos.setPedido(articulosPedidosObjeto.getPedido());
        articulosPedidos.setProducto(articulosPedidosObjeto.getProducto());
        articulosPedidos.setCantidad(articulosPedidosObjeto.getCantidad());
        articulosPedidos.setPrecio(articulosPedidosObjeto.getPrecio());

        ArticulosPedidos articulosPedidosActualizado = iServicioArticulosPedidos.saveArticulosPedidos(articulosPedidos);
        return ResponseEntity.ok(articulosPedidosActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarArticulosPedidos(@PathVariable Integer id) {
        iServicioArticulosPedidos.eliminarArticuloPedido(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<ArticulosPedidos> obtenerArticulosPedidosPorPedido(@PathVariable Integer pedidoId) {
        return iServicioArticulosPedidos.obtenerArticulosPedidosPorPedido(pedidoId);
    }

    @GetMapping("/estadopedido/{estadoPedidoId}")
    public List<ArticulosPedidos> obtenerArticulosPedidosPorProducto(@PathVariable Integer productoId) {
        return iServicioArticulosPedidos.obtenerArticulosPedidosPorProducto(productoId);
    }
}
