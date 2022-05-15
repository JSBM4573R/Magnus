package com.system.reservation.magnus.service;

import java.util.List;
import java.util.Optional;

import com.system.reservation.magnus.model.Client;
import com.system.reservation.magnus.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client>getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client>getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client client){
        if (client.getIdClient()==null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> consulta=clientRepository.getClient(client.getIdClient());
            if (consulta.isEmpty()){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client){
        if (client.getIdClient()!=null){
            Optional<Client> consulta=clientRepository.getClient(client.getIdClient());
            if (!consulta.isEmpty()){
                if (client.getName()!=null) {
                    consulta.get().setName(client.getName());
                }
                if (client.getEmail()!=null) {
                    consulta.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!=null) {
                    consulta.get().setPassword(client.getPassword());
                }
                if (client.getAge()!=null) {
                    consulta.get().setAge(client.getAge());
                }
                return clientRepository.save(consulta.get());
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int id){
        Optional<Client> consulta=clientRepository.getClient(id);
        if (!consulta.isEmpty()) {
            clientRepository.delete(consulta.get());
            return true;            
        }
        return false;
    }

}
