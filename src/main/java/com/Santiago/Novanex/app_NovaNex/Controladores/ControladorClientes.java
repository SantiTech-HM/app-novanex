package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Clientes;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorClientes {

    @Autowired
    private IServicioClientes iServicioClientes;

    @GetMapping ("clientes")
    public List<Clientes> getClientes() {
        return iServicioClientes.listClientes();
    }

    @GetMapping ("cliente/{id}")
    public ResponseEntity<Clientes> getClienteById(@PathVariable Integer id) {
       Clientes clientes = iServicioClientes.findClientesById(id);
       if (clientes == null){
           throw new ExceptionNoFound("El cliente no existe:" + id);
       }
       return ResponseEntity.ok(clientes);
    }
    @PostMapping ("clientes")
    public Clientes postCliente(@RequestBody Clientes clientes) {
        return iServicioClientes.saveClientes(clientes);
    }
    @PutMapping ("clientes/{id}")
    public ResponseEntity<Clientes> putClienteById(@PathVariable Integer id, @RequestBody Clientes clientesObjeto) {
        Clientes clientes = iServicioClientes.findClientesById(id);
        if (clientes == null){
            throw new ExceptionNoFound("ID de cliente no encontrado:" + id);
        }
        clientes.setNombre(clientesObjeto.getNombre());
        clientes.setApellidos(clientesObjeto.getApellidos());
        clientes.setCorreo(clientesObjeto.getCorreo());
        clientes.setTelefono(clientesObjeto.getTelefono());
        clientes.setDireccion(clientesObjeto.getDireccion());
        clientes.setFechaNacimiento(clientesObjeto.getFechaNacimiento());


        Clientes updateClientes = iServicioClientes.saveClientes(clientes);
        return ResponseEntity.ok(updateClientes);
    }
    @DeleteMapping("clientes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClientesById(@PathVariable Integer id){
        Clientes clientes = iServicioClientes.findClientesById(id);
        if (clientes == null){
            throw new ExceptionNoFound("ID de cliente no encontrado:" + id);
        }
        iServicioClientes.deleteClientes(clientes);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Cliente eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
