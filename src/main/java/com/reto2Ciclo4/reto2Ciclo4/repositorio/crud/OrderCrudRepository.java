package com.reto2Ciclo4.reto2Ciclo4.repositorio.crud;

import com.reto2Ciclo4.reto2Ciclo4.modelo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone);
}
