package com.system.reservation.magnus.repository;

import java.util.List;
import java.util.Optional;

import com.system.reservation.magnus.model.Audience;
import com.system.reservation.magnus.repository.crud.AudienceCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AudienceRepository {

    @Autowired
    AudienceCrudRepository audienceCrudRepository;

    public List<Audience>getAll(){
        return (List<Audience>)audienceCrudRepository.findAll();
    }

    public Optional<Audience>getAudience(int id){
        return audienceCrudRepository.findById(id);
    }

    public Audience save(Audience audience){
        return audienceCrudRepository.save(audience);
    }

    public void delete(Audience audience){
        audienceCrudRepository.delete(audience);
    }

}
