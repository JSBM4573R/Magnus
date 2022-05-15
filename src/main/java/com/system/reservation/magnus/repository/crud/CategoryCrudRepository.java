package com.system.reservation.magnus.repository.crud;

import com.system.reservation.magnus.model.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository <Category, Integer> {
    
}
