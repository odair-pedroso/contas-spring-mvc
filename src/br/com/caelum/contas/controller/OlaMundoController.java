package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // marcação spring indicando que esta classe é do tipo Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring") // Marcação que informa quando o metodo deverá ser chamado, no exemplo ao
										// abrir
	// o navegador
	public String execute() {
		System.out.println("Executando uma logica com Spring MVC");

		// logica ...

		return "olaMundo/ok";
	}

}
