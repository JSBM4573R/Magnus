package com.system.reservation.magnus.repository.crud;

import com.system.reservation.magnus.model.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
    
}
