package com.system.reservation.magnus.repository;

import java.util.List;
import java.util.Optional;

import com.system.reservation.magnus.model.User;
import com.system.reservation.magnus.repository.crud.UserCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @author JSBM
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepo;

    public Optional<User> getUser(int id) {
        return userCrudRepo.findById(id);
    }

    public Optional<User> getNameUser(String name){
        return userCrudRepo.findByName(name);
    }

    public List<User> ListUsers() {
        return (List<User>)userCrudRepo.findAll();
    }

    public User save(User user) {
        return userCrudRepo.save(user);
    }

    public Optional<User> existEmail(String email) {
        return userCrudRepo.findByEmail(email);
    }

    public Optional<User> authenticate(String email, String password) {
        return userCrudRepo.findByEmailAndPassword(email, password);
    }
}
