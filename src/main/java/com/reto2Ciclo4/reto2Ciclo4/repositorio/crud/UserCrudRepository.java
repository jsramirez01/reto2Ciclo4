package com.reto2Ciclo4.reto2Ciclo4.repositorio.crud;


import com.reto2Ciclo4.reto2Ciclo4.modelo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserCrudRepository extends MongoRepository<User, Integer> {
        Optional<User> findByEmail(String email);
        Optional<User> findByEmailAndPassword(String email,String password);
    }



