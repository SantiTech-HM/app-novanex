package com.Santiago.Novanex.app_NovaNex.Controladores;

import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v7/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorPedidos {



    @Autowired
    private final IServicioPedidos iServicioPedidos;

    public ControladorPedidos(IServicioPedidos iServicioPedidos) {
        this.iServicioPedidos = iServicioPedidos;
    }

    @PostMapping("pedido")
    public ResponseEntity<PedidosDTO> crearPedido(@RequestBody PedidosDTO pedidoDTO) {
        PedidosDTO nuevoPedido = iServicioPedidos.crearPedido(pedidoDTO);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @PutMapping("pedido/{id}")
    public ResponseEntity<PedidosDTO> actualizarPedido(@PathVariable Integer id, @RequestBody PedidosDTO pedidoDTO) {
        PedidosDTO pedidoActualizado = iServicioPedidos.actualizarPedido(id, pedidoDTO);
        return ResponseEntity.ok(pedidoActualizado);
    }

    @DeleteMapping("pedido/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Integer id) {
        iServicioPedidos.eliminarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("pedido/{id}")
    public ResponseEntity<PedidosDTO> obtenerPedidoPorId(@PathVariable Integer id) {
        PedidosDTO pedido = iServicioPedidos.obtenerPedidoPorId(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("pedidos")
    public ResponseEntity<List<PedidosDTO>> listarTodosPedidos() {
        List<PedidosDTO> pedidos = iServicioPedidos.listarTodosPedidos();
        return ResponseEntity.ok(pedidos);
    }
}
