package com.system.reservation.magnus.service;

import java.util.List;
import java.util.Optional;

import com.system.reservation.magnus.model.Message;
import com.system.reservation.magnus.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    public List<Message>getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message>getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message message){
        if (message.getIdMessage()==null) {
            return messageRepository.save(message);
        }else{
            Optional<Message> consulta=messageRepository.getMessage(message.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if (message.getIdMessage()!=null) {
            Optional<Message> consulta=messageRepository.getMessage(message.getIdMessage());
            if (!consulta.isEmpty()) {
                if (message.getMessageText()!=null) {
                    consulta.get().setMessageText(message.getMessageText());
                }
                return messageRepository.save(consulta.get());
            }
        }
        return message;
    }

    public boolean deleteMessage(int id){
        Optional<Message> consulta=messageRepository.getMessage(id);
        if (!consulta.isEmpty()) {
            messageRepository.delete(consulta.get());
            return true;
        }
        return false;
    }
}
