package com.bhavik.controller;

import com.bhavik.model.guide.message.Message;
import com.bhavik.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value = {"/","/{id}"})
    public ResponseEntity<List<Message>> fetchAllMessages(@PathVariable(required = false) Optional<Long> id){

        if(id.isPresent()) {
            Message message = messageService.findOneMessage(id.get());
            return message == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(Arrays.asList(message));
        }

        List<Message> messageList = messageService.getAllMessage();
        return messageList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(messageList);
    }



    @PostMapping("/dummy")
    public ResponseEntity<Void> storeDummyMessages(){
        messageService.storeDummyMessages();
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
