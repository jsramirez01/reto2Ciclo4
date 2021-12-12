package com.reto2Ciclo4.reto2Ciclo4.repositorio;


import com.reto2Ciclo4.reto2Ciclo4.modelo.Order;
import com.reto2Ciclo4.reto2Ciclo4.repositorio.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    public List<Order> getAll(){
        return orderCrudRepository.findAll();
    }

    public Optional<Order>  getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }
    public Order create(Order order){
        return orderCrudRepository.save(order);
    }

    public  void update(Order order){
        orderCrudRepository.save(order);
    }
    public void delete (Order order){
        orderCrudRepository.delete(order);
    }

    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }



}
