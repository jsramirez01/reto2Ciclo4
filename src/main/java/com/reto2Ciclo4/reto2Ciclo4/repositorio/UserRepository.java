package com.reto2Ciclo4.reto2Ciclo4.repositorio;


import java.util.List;
import java.util.Optional;

import com.reto2Ciclo4.reto2Ciclo4.modelo.User;
import com.reto2Ciclo4.reto2Ciclo4.repositorio.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
    /**
     * @Autowired
     */
    @Autowired
    /**
     * UserCrudRepository userCrudRepository
     */
    private UserCrudRepository userCrudRepository;
    /**
     * List<User> getAll()
     * @return (List<User>) userCrudRepository.findAll()
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    //Reto 3
    /**
     * consulta por id
     * @param id
     * @return userCrudRepository.findById(id)
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * usuario nuevo
     * @param user
     * @return userCrudRepository.save(user)
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * actualizar usuario
     * @param user
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    //Reto 5
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }

     /*listar usuario con id mayor
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }*/



}

