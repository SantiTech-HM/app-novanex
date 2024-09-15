package com.Santiago.Novanex.app_NovaNex.Controladores;



import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.MetodosPago;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExceptionNoFound;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioMetodosPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v6")
@CrossOrigin("value = htttp://localhost:4200")

public class ControladorMetodosPago {

    @Autowired
    private IServicioMetodosPago iServicioMetodosPago;

    @GetMapping("metodosdepago")
    public List<MetodosPago> getMetodosDePago() {
        return iServicioMetodosPago.listMetodosPago();
    }
    @GetMapping("metododepago/{id}")
    public ResponseEntity<MetodosPago> getMetodoDePagoById(@PathVariable Integer id) {
        MetodosPago metodosPago = iServicioMetodosPago.findMetodosPagoById(id);
        if (metodosPago == null){
            throw new ExceptionNoFound("el metodo de pago no existe:" + id);
        }
        return ResponseEntity.ok(metodosPago);
    }

    @PostMapping("metodospago")
    public MetodosPago postMetodosPago(@RequestBody MetodosPago metodosPago){
        return iServicioMetodosPago.saveMetodosPago(metodosPago);
    }
    @PutMapping("metodospago/{id}")
    public ResponseEntity<MetodosPago> putMetodosPagoById(@PathVariable Integer id, @RequestBody MetodosPago metodosPagoObjeto){
        MetodosPago metodosPago = iServicioMetodosPago.findMetodosPagoById(id);
        if(metodosPago == null){
            throw new ExceptionNoFound("ID del metodo de pago no encontrado:" + id);

        }
        metodosPago.setMetodo(metodosPagoObjeto.getMetodo());

        MetodosPago updateMetodosPago = iServicioMetodosPago.saveMetodosPago(metodosPago);
        return ResponseEntity.ok(metodosPago);
    }

    @ DeleteMapping("metodospago/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMetodosPagoById(@PathVariable Integer id) {
        MetodosPago metodosPago = iServicioMetodosPago.findMetodosPagoById(id);
        if (metodosPago == null){
            throw new ExceptionNoFound("ID metodo de pago no encontrado:" + id);
        }

        iServicioMetodosPago.deleteMetodosPago(metodosPago);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Metodo de pago eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
