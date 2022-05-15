package com.system.reservation.magnus.repository.crud;

import com.system.reservation.magnus.model.Message;

import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository <Message, Integer> {
    
}
