package com.Santiago.Novanex.app_NovaNex.Controladores;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Pedidos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcionDePedidos;
import com.Santiago.Novanex.app_NovaNex.Mapeadores.MapeadorPedidos;
import com.Santiago.Novanex.app_NovaNex.ObjetoDeTransferenciaDeDatos.PedidosDTO;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v7")
@CrossOrigin(value = "")
public class ControladorPedidos {

    @Autowired
    private IServicioPedidos iServicioPedidos;

    @Autowired
    private MapeadorPedidos mapeadorPedidos;

    @PostMapping
    public ResponseEntity<PedidosDTO> crearPedido(@RequestBody PedidosDTO pedidosDTO) {
        Pedidos pedidos = mapeadorPedidos.aEntity(pedidosDTO);
        Pedidos pedidoGuardado = iServicioPedidos.savePedido(pedidos);
        PedidosDTO resultadoDTO = mapeadorPedidos.aDTO(pedidoGuardado);
        return ResponseEntity.ok(resultadoDTO);
    }

    @GetMapping("pedido/{id}")
    public ResponseEntity<PedidosDTO> findPedido(@PathVariable Integer id) {
        Optional<Pedidos> pedidoOpcional = iServicioPedidos.findPedidoById(id);
        if (pedidoOpcional.isPresent()) {
            PedidosDTO pedidoDTO = mapeadorPedidos.aDTO(pedidoOpcional.get());
            return ResponseEntity.ok(pedidoDTO);
        } else {
            throw new ExcepcionDePedidos("Pedido no encontrado con ID: " + id);
        }
    }
    @PutMapping("pedido/{id}")
    public ResponseEntity<PedidosDTO> updatePedido(@PathVariable Integer id, @RequestBody PedidosDTO pedidosDTO) {

        if (pedidosDTO == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Pedidos> pedidoExistente = iServicioPedidos.findPedidoById(id);
        if (!pedidoExistente.isPresent()) {
            throw new ExcepcionDePedidos("No se puede actualizar, pedido no encontrado con ID: " + id);
        }
        Pedidos pedidos = mapeadorPedidos.aEntity(pedidosDTO);
        pedidos.setId(id);
        Pedidos pedidoActualizado = iServicioPedidos.savePedido(pedidos);
        PedidosDTO resultadoDTO = mapeadorPedidos.aDTO(pedidoActualizado);
        return ResponseEntity.ok(resultadoDTO);
    }

    @GetMapping("pedidos")
    public ResponseEntity<List<PedidosDTO>> findAllPedidos() {
        List<Pedidos> pedidos = iServicioPedidos.findAllPedidos();
        List<PedidosDTO> pedidosDTO = pedidos.stream()
                .map(mapeadorPedidos::aDTO)
                .toList();
        return ResponseEntity.ok(pedidosDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        iServicioPedidos.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}
