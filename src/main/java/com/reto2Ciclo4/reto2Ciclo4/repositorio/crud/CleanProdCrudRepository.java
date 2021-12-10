package com.reto2Ciclo4.reto2Ciclo4.repositorio.crud;


import com.reto2Ciclo4.reto2Ciclo4.modelo.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleanProdCrudRepository extends MongoRepository<CleaningProduct, Integer> {
}
