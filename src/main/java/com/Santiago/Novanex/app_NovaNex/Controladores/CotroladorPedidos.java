package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v7/")
@CrossOrigin(value = "http://localhost:4200")
public class CotroladorPedidos {


    @Autowired
    private IServicioPedidos iServicioPedidos;

    @GetMapping("pedidos")
    public List<Pedidos> findPedidos() {
        return iServicioPedidos.listPedidos();
    }

    @GetMapping("pedido/{id}")
    public ResponseEntity<Pedidos> findPedidoById(@PathVariable Integer id) {
        Pedidos pedido = iServicioPedidos.findPedidosById(id);
        if (pedido == null) {
            throw new ExcepcionDePedidos("El pedido no existe:" + id);
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping("pedido")
    public ResponseEntity<Pedidos> postPedido(@RequestBody Pedidos pedido) {
        Pedidos pedidoGuardado = iServicioPedidos.savePedidos(pedido);
        return ResponseEntity.ok(pedidoGuardado);
    }

    @PutMapping("pedido/{id}")
    public ResponseEntity<Pedidos> updatePedido(@PathVariable Integer id, @RequestBody Pedidos pedidoDetails) {
        Pedidos pedido = iServicioPedidos.updatePedidos(id, pedidoDetails);
        //Pedidos pedido = iServicioPedidos.findPedidosById(id)
        if (pedido == null){
            throw new ExcepcionDePedidos("ID de pedido no encontrado:" + id);
        }

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("pedido/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePedido(@PathVariable Integer id) {
        Pedidos pedidoEliminado = iServicioPedidos.findPedidosById(id);
        if (pedidoEliminado == null) {
            throw new ExcepcionDePedidos("ID de pedido no encontrado:" + id);
        }
        iServicioPedidos.deletePedidos(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("pedido eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("cliente/{clienteId}")
    public List<Pedidos> findPedidosPorCliente(@PathVariable Integer clienteId) {
        return iServicioPedidos.findPedidosPorCliente(clienteId);
    }

    @GetMapping("estado/{estadoId}")
    public List<Pedidos> findPedidosPorEstado(@PathVariable Integer estadoId) {
        return iServicioPedidos.findPedidosPorEstado(estadoId);
    }
    @GetMapping("estadodevolucion/{estadodevolucionId}")
    public List<Pedidos> findPedidosPorEstadoDevolucion(@PathVariable Integer estadoDevolucionId) {
        return iServicioPedidos.findPedidosPorEstadoDevolucion(estadoDevolucionId);
    }
    @GetMapping("metodopago/{metodopagoId}")
    public List<Pedidos> findPedidosPorMetodoPago(@PathVariable Integer metodoPagoId) {
        return iServicioPedidos.findPedidosPorMetodoPago(metodoPagoId);
    }

    @GetMapping("fechas")
    public List<Pedidos> findPedidosPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return iServicioPedidos.findPedidosPorRangoFechas(inicio, fin);
    }
}
