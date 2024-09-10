package com.Santiago.Novanex.app_NovaNex.Controladores;

import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.EntidadClientes;
import com.Santiago.Novanex.app_NovaNex.Repositorios.IRepositorioClientes;
import com.Santiago.Novanex.app_NovaNex.Servicios.ServicioClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/clientes")
@RestController
public class ControladorClientes {


    @Autowired
    private ServicioClientes servicioClientes;

    @GetMapping
    public Iterable<EntidadClientes> list() {
        return servicioClientes.findAll();
    }

    @GetMapping("{id}")
    public EntidadClientes get(@PathVariable Integer id) {
        return servicioClientes.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void EntidadClientes crear(@RequestBody EntidadClientes entidadClientes) {
        return servicioClientes.crear(entidadClientes);
    }
    @PutMapping("{id}")
    public EntidadClientes actualizar(@PathVariable Integer id,
                                      @RequestBody EntidadClientes from){
        return servicioClientes.actualizar(id, from);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Integer id){
        servicioClientes.eliminar(id);
    }

}
