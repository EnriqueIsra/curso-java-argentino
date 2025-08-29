package com.enrique.springboot.backend.chat.app.controllers;

import com.enrique.springboot.backend.chat.app.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Controller
@CrossOrigin({"http://localhost:5173", "http://localhost:4200/"})
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message){
        message.setDate(new Date().getTime());
        message.setText("Recibido por el broker: " + message.getText());
        return message;
    }
}
