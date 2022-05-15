package com.system.reservation.magnus.repository.crud;

import java.util.Optional;

import com.system.reservation.magnus.model.User;

import org.springframework.data.repository.CrudRepository;


/**
 * @author JSBM
 */
public interface UserCrudRepository extends CrudRepository <User, Integer> {
    Optional<User> findByName(String name);
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);
}

