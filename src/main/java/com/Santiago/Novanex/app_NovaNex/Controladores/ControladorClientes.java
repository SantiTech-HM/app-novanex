package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EntidadClientes;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorClientes {

    @Autowired
    private IServicioClientes iServicioClientes;

    @GetMapping("/clientes")
    public List<EntidadClientes> listEntidadClientes() {
        return iServicioClientes.listEntidadClientes();
    }
}
