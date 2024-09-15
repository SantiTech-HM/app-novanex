package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EstadosPedido;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExceptionNoFound;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioEstadosPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v4/")
@CrossOrigin("value = http://localhost:4200")
public class ControladorEstadosPedido {

    @Autowired
    private IServicioEstadosPedido iServicioEstadosPedido;

    @GetMapping("estadospedidos")
    public List<EstadosPedido> getEstadosPedidos() {
        return iServicioEstadosPedido.listEstadosPedido();
    }
    @GetMapping("estadodelpedido/{id}")
    public ResponseEntity<EstadosPedido> getEstadoDelPedidoById(@PathVariable Integer id) {
            EstadosPedido estadosPedido = iServicioEstadosPedido.findEstadosPedidoById(id);
            if (estadosPedido == null){
                throw new ExceptionNoFound("el estado del pedido no existe:" + id);
            }
            return ResponseEntity.ok(estadosPedido);
    }

    @PostMapping("estadospedido")
    public EstadosPedido postEstadosPedido(@RequestBody EstadosPedido estadosPedido){
        return iServicioEstadosPedido.saveEstadosPedido(estadosPedido);
    }
    @PutMapping("estadopedido/{id}")
    public ResponseEntity<EstadosPedido> putEstadosPedidoById(@PathVariable Integer id, @RequestBody EstadosPedido estadosPedidoObjeto){
        EstadosPedido estadosPedido = iServicioEstadosPedido.findEstadosPedidoById(id);
        if(estadosPedido == null){
            throw new ExceptionNoFound("ID estado del pedido no encontrado:" + id);

        }
        estadosPedido.setEstado(estadosPedidoObjeto.getEstado());

        EstadosPedido updateEstadosPedido = iServicioEstadosPedido.saveEstadosPedido(estadosPedido);
        return ResponseEntity.ok(estadosPedido);
    }

    @ DeleteMapping("estadospedido/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEstadosPedidoById(@PathVariable Integer id) {
        EstadosPedido estadosPedido = iServicioEstadosPedido.findEstadosPedidoById(id);
        if (estadosPedido == null){
            throw new ExceptionNoFound("ID estado del pedido  no encontrado:" + id);
        }

    iServicioEstadosPedido.deleteEstadosPedido(estadosPedido);
    Map<String, Boolean> response = new HashMap<>();
    response.put("Estado del pedido eliminado", Boolean.TRUE);
    return ResponseEntity.ok(response);
}
}
