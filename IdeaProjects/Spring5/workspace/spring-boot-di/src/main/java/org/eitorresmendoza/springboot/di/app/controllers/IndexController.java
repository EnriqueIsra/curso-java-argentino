package org.eitorresmendoza.springboot.di.app.controllers;

import org.eitorresmendoza.springboot.di.app.models.service.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@Autowired
	@Qualifier("miServicioComplejo")
	private IServicio servicio;
	
	@GetMapping({ "/index", "/", "" })
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		model.addAttribute("titulo", "Hola que tal");
		return "index";
	}

	public void setServicio(IServicio servicio) {
		this.servicio = servicio;
	}

}
