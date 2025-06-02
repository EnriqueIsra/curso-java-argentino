package com.enrique.springboot.springmvc.app.controllers;

import com.enrique.springboot.springmvc.app.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class UserController {

    @GetMapping({"/view", "/", "/another"})
    public String view(Model model){
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("message", "mensaje");
        model.addAttribute("user", new User("Enrique", "Torres"));
        return "view";
    }
}
