package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {
	
	@RequestMapping(value = "/")
	public ModelAndView Inicio() {

		ModelAndView modelAndView = new ModelAndView("inicio");
		
		return modelAndView;
	}
}
