package com.reto2Ciclo4.reto2Ciclo4.repositorio.crud;


import com.reto2Ciclo4.reto2Ciclo4.modelo.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CleanProdCrudRepository extends MongoRepository<CleaningProduct, Integer> {
    public List<CleaningProduct> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByDescriptionLike(String description);
}
