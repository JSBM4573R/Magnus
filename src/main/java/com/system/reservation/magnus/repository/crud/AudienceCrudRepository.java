package com.system.reservation.magnus.repository.crud;

import java.util.Optional;

import com.system.reservation.magnus.model.Audience;

import org.springframework.data.repository.CrudRepository;

public interface AudienceCrudRepository extends CrudRepository <Audience, Integer> {
    Optional<Audience> findByName(String name);
}
