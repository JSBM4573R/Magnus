package com.system.reservation.magnus.repository;

import java.util.List;
import java.util.Optional;

import com.system.reservation.magnus.model.Client;
import com.system.reservation.magnus.repository.crud.ClientCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client>getAll(){
        return (List<Client>)clientCrudRepository.findAll();
    }

    public Optional<Client>getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }

    
}
