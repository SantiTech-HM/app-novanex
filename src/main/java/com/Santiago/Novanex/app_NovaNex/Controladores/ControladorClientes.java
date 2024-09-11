package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EntidadClientes;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorClientes {

    @Autowired
    private IServicioClientes iServicioClientes;

    @GetMapping("/clientes")
    public List<EntidadClientes> getEntidadClientes() {
        return iServicioClientes.listEntidadClientes();
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<EntidadClientes> getEntidadClienteById(@PathVariable Integer id) {
       EntidadClientes entidadClientes = iServicioClientes.findEntidadClientesById(id);
       if (entidadClientes == null){
           throw new Exception("El cliente no existe");
       }
    }
}
