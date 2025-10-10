package com.enrique.springboot.backend.chat.app.services;

import com.enrique.springboot.backend.chat.app.models.Message;
import com.enrique.springboot.backend.chat.app.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessageServiceMongo implements MessageService{

    private final MessageRepository repository;

    public MessageServiceMongo(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Message> findAll() {
        List<Message> messages = repository.findFirst10ByOrderByDateDesc();
        Collections.reverse(messages);
        return messages;
    }

    @Override
    public void save(Message message) {
        repository.save(message);
    }
}
