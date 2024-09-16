package com.Santiago.Novanex.app_NovaNex.Controladores;


import com.Santiago.Novanex.app_NovaNex.EntidadesOModelos.Categorias;
import com.Santiago.Novanex.app_NovaNex.Excepciones.ExcepcioGlobal;
import com.Santiago.Novanex.app_NovaNex.Servicios.IServicioCategorias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorCategorias {

    @Autowired
    private IServicioCategorias iServicioCategorias;

    @GetMapping("categorias")
    public List<Categorias> getCategorias() {
        return iServicioCategorias.listCategorias();
    }

    @GetMapping ("categoria/{id}")
    public ResponseEntity<Categorias> getCategoriaById(@PathVariable Integer id) {
        Categorias categorias = iServicioCategorias.findCategoriasById(id);
        if (categorias == null){
            throw new ExcepcioGlobal("la categotia no existe:" + id);
        }
        return ResponseEntity.ok(categorias);
    }
    @PostMapping ("categorias")
    public Categorias postCategoria(@RequestBody Categorias categorias) {
        return iServicioCategorias.saveCategorias(categorias);
    }
    @PutMapping ("categorias/{id}")
    public ResponseEntity<Categorias> putCategoriaById(@PathVariable Integer id, @RequestBody Categorias categoriasObjeto) {
        Categorias categorias = iServicioCategorias.findCategoriasById(id);
        if (categorias == null){
            throw new ExcepcioGlobal("ID de la categoria no encontrado:" + id);
        }
        categorias.setNombre(categoriasObjeto.getNombre());
        categorias.setDescripcion(categoriasObjeto.getDescripcion());

        Categorias updateCategorias = iServicioCategorias.saveCategorias(categorias);
        return ResponseEntity.ok(updateCategorias);
    }
    @DeleteMapping("categorias/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategoriasById(@PathVariable Integer id){
        Categorias categorias = iServicioCategorias.findCategoriasById(id);
        if (categorias == null){
            throw new ExcepcioGlobal("ID de producto no encontrado:" + id);
        }
        iServicioCategorias.deleteCategorias(categorias);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Categoria eliminada", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
