package br.com.caelum.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // marca��o spring indicando que esta classe � do tipo Controller
public class OlaMundoController {

	@RequestMapping("/olaMundoSpring") // Marca��o que informa quando o metodo dever� ser chamado, no exemplo ao
										// abrir
	// o navegador
	public String execute() {
		System.out.println("Executando uma logica com Spring MVC");

		// logica ...

		return "olaMundo/ok";
	}

}
