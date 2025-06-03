package com.enrique.springboot.springmvc.app.controllers;

import com.enrique.springboot.springmvc.app.entities.User;
import com.enrique.springboot.springmvc.app.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping({"/view", "/another"})
    public String view(Model model){
        model.addAttribute("title", "Hola Mundo Spring Boot!!!");
        model.addAttribute("message", "mensaje");
        model.addAttribute("user", new User("Enrique", "Torres"));
        return "view";
    }

    @GetMapping("/form")
    public String list(Model model){
        model.addAttribute("title", "Listado de Usuarios");
        model.addAttribute("users", service.findAll());
        return  "list";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("title", "Listado de Usuarios");
        model.addAttribute("user", new User());
        return  "form";
    }

    @GetMapping("/form/{id}")
    public String form(@PathVariable Long id, Model model, RedirectAttributes redirect){
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isPresent()){
            model.addAttribute("title", "Editar Usuario");
            model.addAttribute("user", optionalUser.get());
            return  "form";
        } else {
            redirect.addFlashAttribute("error", "el usuario con id " +
                    id +
                    " no existe en la base de datos");
            return "redirect:/users";
        }
    }

    @PostMapping
    public String form(User user, Model model, RedirectAttributes redirect){

        String message = (user.getId() > 0)? "El usuario " +
                user.getName() +
                " se ah actualizado con éxito" :
                "El usuario " +
                user.getName() +
                " se ah creado con éxito";

        service.save(user);
        redirect.addFlashAttribute("success", message);
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isPresent()){
            redirect.addFlashAttribute("success", "El usuario " +
                    optionalUser.get().getName() +
                    " se ah eliminado con éxito");
            service.remove(id);
            return  "redirect:/users";
        }
        redirect.addFlashAttribute("error", "El usuario con el id " +
                id +
                " no existe en el sistema");
        return "redirect:/users";
    }
}
