package com.reto2Ciclo4.reto2Ciclo4.web;


import com.reto2Ciclo4.reto2Ciclo4.modelo.CleaningProduct;
import com.reto2Ciclo4.reto2Ciclo4.servicios.CleanProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CleanProdController {
    @Autowired
    private CleanProdService cleanProdService;

    //Listar todo
    @GetMapping("/all")
    public List<CleaningProduct> getAll(){
        return cleanProdService.getAll();
    }

    //Consultar por id
    @GetMapping("/{id}")
    public Optional<CleaningProduct> getCleaningProduct(@PathVariable("id") Integer id) {
        return cleanProdService.getCleaningProduct(id);
    }

    //Guardar producto nuevo
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CleaningProduct cleaningProduct){
        cleanProdService.save(cleaningProduct);
    }

    //Actualizar producto
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct cleaningProduct){
        return cleanProdService.update(cleaningProduct);
    }

    //Borrar producto por id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return cleanProdService.delete(id);
    }
}
