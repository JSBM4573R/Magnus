package com.system.reservation.magnus.service;

import java.util.List;
import java.util.Optional;

import com.system.reservation.magnus.model.User;
import com.system.reservation.magnus.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Optional<User> getUser(int id) {
        return userRepo.getUser(id);
    }

    public List<User> ListUsers(){
        return userRepo.ListUsers();
    }

    public boolean existEmail(String email) {
        Optional<User> consulta = userRepo.existEmail(email);
        if (consulta.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    public User register(User user) {
        if (user.getId()==null){
            if(existEmail(user.getEmail()) == false) {
                return userRepo.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public User authenticate(String email, String password) {
        Optional<User> consulta = userRepo.authenticate(email, password);
        if(consulta.isEmpty()){
            return new User();
        } else {
            return consulta.get();
        }
    }

    public User getName(String name) {
        Optional<User> consulta = userRepo.getNameUser(name);
        if(!consulta.isEmpty()){
            if(existEmail(consulta.get().getEmail()) == true){
                return consulta.get();
            } else {
                return new User();
            }
        }return new User();
    }
}
