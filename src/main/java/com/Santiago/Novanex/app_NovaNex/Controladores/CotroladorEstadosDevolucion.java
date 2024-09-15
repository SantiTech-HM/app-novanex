package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Clientes;
import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EstadosDevolucion;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExceptionNoFound;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioClientes;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioEstadosDevolucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v5/")
@CrossOrigin(value = "http://localhost:4200")
public class CotroladorEstadosDevolucion {


    @Autowired
    private IServicioEstadosDevolucion iServicioEstadosDevolucion;

    @GetMapping("estadosdevoluciones")
    public List<EstadosDevolucion> getEstadosDevoluciones() {
        return iServicioEstadosDevolucion.listEstadosDevolucion();
    }

    @GetMapping ("estadodedevolucion/{id}")
    public ResponseEntity<EstadosDevolucion> getEstadoDeDevolucionById(@PathVariable Integer id) {
        EstadosDevolucion estadosDevolucion = iServicioEstadosDevolucion.findEstadosDevolucionById(id);
        if (estadosDevolucion == null){
            throw new ExceptionNoFound("La devolucion no existe:" + id);
        }
        return ResponseEntity.ok(estadosDevolucion);
    }
    @PostMapping ("estadosdevoluciones")
    public EstadosDevolucion postEstadoDevolucion(@RequestBody EstadosDevolucion estadosDevolucion) {
        return iServicioEstadosDevolucion.saveEstadosDevolucion(estadosDevolucion);
    }
    @PutMapping ("estadosdevoluciones/{id}")
    public ResponseEntity<EstadosDevolucion> putEstadoDevolucionById(@PathVariable Integer id, @RequestBody EstadosDevolucion estadosDevolucionObjeto) {
        EstadosDevolucion estadosDevolucion = iServicioEstadosDevolucion.findEstadosDevolucionById(id);
        if (estadosDevolucion == null){
            throw new ExceptionNoFound("ID del estado de la devolucion no encontrado:" + id);
        }
        estadosDevolucion.setEstado(estadosDevolucionObjeto.getEstado());

        EstadosDevolucion updateEstadosDevolucion = iServicioEstadosDevolucion.saveEstadosDevolucion(estadosDevolucion);
        return ResponseEntity.ok(updateEstadosDevolucion);
    }
    @DeleteMapping("estadosdevoluciones/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEstadosdevolucionById(@PathVariable Integer id){
        EstadosDevolucion estadosDevolucion = iServicioEstadosDevolucion.findEstadosDevolucionById(id);
        if (estadosDevolucion == null){
            throw new ExceptionNoFound("ID de estado de devolucion no encontrado:" + id);
        }
        iServicioEstadosDevolucion.deleteEstadosDevolucion(estadosDevolucion);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Estado de delolucion eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
