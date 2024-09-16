package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Productos;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcioGlobal;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorProducto {

    @Autowired
    private IServicioProductos iServicioProductos;

    @GetMapping("productos")
    public List<Productos> getProductos() {
        return iServicioProductos.listProductos();
    }

    @GetMapping ("producto/{id}")
    public ResponseEntity<Productos> getProductoById(@PathVariable Integer id) {
        Productos productos = iServicioProductos.findProductosById(id);
        if (productos == null){
            throw new ExcepcioGlobal("El producto no existe:" + id);
        }
        return ResponseEntity.ok(productos);
    }
    @PostMapping ("productos")
    public Productos postProducto(@RequestBody Productos productos) {
        return iServicioProductos.saveProductos(productos);
    }
    @PutMapping ("productos/{id}")
    public ResponseEntity<Productos> putProductoById(@PathVariable Integer id, @RequestBody Productos productosObjeto) {
        Productos productos = iServicioProductos.findProductosById(id);
        if (productos == null){
            throw new ExcepcioGlobal("ID de producto no encontrado:" + id);
        }
        productos.setNombre(productosObjeto.getNombre());
        productos.setDescripcion(productosObjeto.getDescripcion());
        productos.setPrecio(productosObjeto.getPrecio());
        productos.setStock(productosObjeto.getStock());
        productos.setFechaCreacion(productosObjeto.getFechaCreacion());

        Productos updateProductos = iServicioProductos.saveProductos(productos);
        return ResponseEntity.ok(updateProductos);
    }
    @DeleteMapping("productos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProductosById(@PathVariable Integer id){
        Productos productos = iServicioProductos.findProductosById(id);
        if (productos == null){
            throw new ExcepcioGlobal("ID de producto no encontrado:" + id);
        }
        iServicioProductos.deleteProductos(productos);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Producto eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
