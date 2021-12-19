package com.reto2Ciclo4.reto2Ciclo4.repositorio;

import com.reto2Ciclo4.reto2Ciclo4.modelo.CleaningProduct;
import com.reto2Ciclo4.reto2Ciclo4.repositorio.crud.CleanProdCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CleanProdRepository {
    @Autowired
    private CleanProdCrudRepository cleanProdCrudRepository;

    public List<CleaningProduct> getAll(){
        return cleanProdCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getCleaningProduct(int id){
        return cleanProdCrudRepository.findById(id);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct){
        return cleanProdCrudRepository.save(cleaningProduct);
    }

    public void update(CleaningProduct cleaningProduct){
        cleanProdCrudRepository.save(cleaningProduct);
    }

    public void delete(CleaningProduct cleaningProduct){
        cleanProdCrudRepository.delete(cleaningProduct);
    }

    public List<CleaningProduct> productsByPrice(double precio){
        return cleanProdCrudRepository.findByPriceLessThanEqual(precio);
    }

    public List<CleaningProduct> findByDescriptionLike(String description){
        return cleanProdCrudRepository.findByDescriptionLike(description);
    }
}
