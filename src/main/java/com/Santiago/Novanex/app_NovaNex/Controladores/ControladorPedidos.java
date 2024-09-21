package com.Santiago.Novanex.app_NovaNex.Controladores;



import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v7/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorPedidos {

    @Autowired
    private IServicioPedidos iServicioPedidos;

    @GetMapping("pedidos")
    public List<Pedidos> obtenerTodosPedidos() {
        return iServicioPedidos.listarTodosPedidos();
    }

    @GetMapping("pedido/{id}")
    public ResponseEntity<Pedidos> obtenerPedidoPorId(@PathVariable Integer id) {
        Pedidos pedido = iServicioPedidos.obtenerPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @PostMapping("pedido")
    public ResponseEntity<Pedidos> crearPedido(@RequestBody Pedidos pedido) {
        Pedidos nuevoPedido = iServicioPedidos.crearPedido(pedido);
        return ResponseEntity.ok(nuevoPedido);
    }

    @PutMapping("pedido/{id}")

    public ResponseEntity<Pedidos> actualizarPedido(@PathVariable Integer id, @RequestBody Pedidos pedidoObjeto) {

        Pedidos pedido = iServicioPedidos.actualizarPedido(id, pedidoObjeto);
        if (pedido == null){
            throw new ExcepcionDePedidos("ID del pedido no encontrado:" + id);
        }
        pedido.setCliente(pedidoObjeto.getCliente());
        pedido.setEstadoPedido(pedidoObjeto.getEstadoPedido());
        pedido.setEstadoDevolucion(pedidoObjeto.getEstadoDevolucion());
        pedido.setMetodoPago(pedidoObjeto.getMetodoPago());
        pedido.setPrecioTotal(pedidoObjeto.getPrecioTotal());
        pedido.setFechaCreacion(pedidoObjeto.getFechaCreacion());

        Pedidos pedidoActualizado = iServicioPedidos.savePedidos(pedido);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        iServicioPedidos.eliminarPedido(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Pedidos> obtenerPedidosPorCliente(@PathVariable Integer clienteId) {
        return iServicioPedidos.obtenerPedidosPorCliente(clienteId);
    }

    @GetMapping("/estadopedido/{estadoPedidoId}")
    public List<Pedidos> obtenerPedidosPorEstadoPedido(@PathVariable Integer estadoPedidoId) {
        return iServicioPedidos.obtenerPedidosPorEstadoPedido(estadoPedidoId);
    }
    @GetMapping("/estadodevolucion/{estadoDevolucionId}")
    public List<Pedidos> obtenerPedidosPorEstadoDevolucion(@PathVariable Integer estadoDevolucionId) {
        return iServicioPedidos.obtenerPedidosPorEstadoDevolucion(estadoDevolucionId);
    }
    @GetMapping("/metodopago/{metodoPagoId}")
    public List<Pedidos> obtenerPedidosPorMetodoPago(@PathVariable Integer metodoPagoId) {
        return iServicioPedidos.obtenerPedidosPorMetodoPago(metodoPagoId);
    }

    @GetMapping("/fechas")
    public List<Pedidos> obtenerPedidosPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return iServicioPedidos.obtenerPedidosPorRangoFechas(inicio, fin);
    }
}
