package com.bhavik.service;

import com.bhavik.model.guide.message.Message;
import com.bhavik.service.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepo messageRepo;

    public List<Message> getAllMessage(){
        List<Message> messageList= new ArrayList<>();
        messageList = messageRepo.findAll();
        return messageList;
    }

    public void storeDummyMessages(){
        Message message1 = new Message("Welcome to Book Store");
        Message message2 = new Message("CopyRight @ 2023");

        addMessage(message1);
        addMessage(message2);
    }


    public void addMessage(Message message){
        messageRepo.save(message);
    }

    public Message findOneMessage(Long id){
        Optional<Message> message = messageRepo.findById(id);
        return message.isPresent() ? message.get() : null;
    }

}
