package com.enrique.springboot.backend.chat.app.controllers;

import com.enrique.springboot.backend.chat.app.models.Message;
import com.enrique.springboot.backend.chat.app.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.Random;

@Controller
@CrossOrigin({"http://localhost:5173", "http://localhost:4200/"})
public class ChatController {

    private String[] colors = {"red", "blue", "green", "magenta", "orange", "purple", "yellow"};
    private final MessageService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

    public ChatController(@Qualifier("messageServiceMongo") MessageService service) {
        this.service = service;
    }

    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message){
        message.setDate(new Date().getTime());
        if(message.getType().equals("NEW_USER")){
            message.setColor(this.colors[new Random().nextInt(colors.length)]);
            message.setText("nuevo usuario");
        } else {
            service.save(message);
        }
        return message;
    }

    @MessageMapping("/writing")
    @SendTo("/chat/writing")
    public String isWriting(String username){
        return username.concat(" está escribiendo...");
    }

    @MessageMapping("/history")
    public void getHistoryMessages(String clientId){
        webSocket.convertAndSend("/chat/history/".concat(clientId), service.findAll());
    }
}
