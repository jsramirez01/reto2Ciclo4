package com.reto2Ciclo4.reto2Ciclo4.servicios;


import com.reto2Ciclo4.reto2Ciclo4.modelo.User;
import com.reto2Ciclo4.reto2Ciclo4.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    /**
     * @Autowired
     */
    @Autowired
    /**
     * Objeto UserRepository userRepository
     */
    private UserRepository userRepository;
    /**
     * List User getAll()
     * @return userRepository.getAll()
     */

    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
     * Optional User getUser(int id)
     * @param id
     * @return return userRepository.getUser(id
     */
    public Optional<User> getUser(int id) {

        return userRepository.getUser(id);
    }

    /**
     * User create(User user)
     * @param user
     * @return user
     */
    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()) {
                if (emailExists(user.getEmail()) == false) {
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else {
                return user;
            }
        }
    }

    /**
     * User update(User user)
     * @param user
     * @return user
     */
    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }

                if (user.getBirthtDay() != null){
                    userDb.get().setBirthtDay(user.getBirthtDay());
                }

                if (user.getMonthBirthtDay() != null){
                    userDb.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }

                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }

                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    /**
     * delete(int userId)
     * @param userId
     * @return aBoolean
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * emailExists(String email)
     * @param email
     * @return userRepository.emailExists(email)
     */
    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    /**
     * User authenticateUser(String email, String password)
     * @param email
     * @param password
     * @return usuario.get() / return new User()
     */
    public User authenticateUser(String email, String password){
        Optional<User> usuario = userRepository.authenticateUser(email, password);
        if (usuario.isEmpty()){
            return new User();
        }
        return usuario.get();
    }

    //Reto 5:
    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }

}


