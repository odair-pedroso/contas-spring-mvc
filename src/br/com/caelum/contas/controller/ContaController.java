package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("/form")
	public String formulario() {
		return "conta/formulario";

	}

	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result) { // dizendo que esta conta tem parametro que nao
																		// pode ser null na model, e usando
																		// bindingResult

		if (result.hasErrors()) {
			return "conta/formulario";
		}

		System.out.println("Conta adicionada é : " + conta.getDescricao());
		ContaDAO dao = new ContaDAO();
		dao.adiciona(conta);

		return "conta/conta-adicionada";

	}

	@RequestMapping("/listaContas")
	public String lista(Model mv) {

		ContaDAO dao = new ContaDAO();
		List<Conta> contas = dao.lista();

		mv.addAttribute("todasContas", contas); // mandando informações para a view jsp é uma classe ponte

		return "conta/lista";
	}

	@RequestMapping("/removeConta")
	public String remove(Conta conta) {

		ContaDAO dao = new ContaDAO();
		dao.remove(conta);

		return "redirect:listaContas";

	}

	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
		ContaDAO dao = new ContaDAO();
		model.addAttribute("conta", dao.buscaPorId(id));
		return "conta/mostra";

	}

	@RequestMapping("/alteraConta")
	public String altera(Conta conta) {
		ContaDAO dao = new ContaDAO();
		dao.altera(conta);
		return "redirect:listaContas";
	}

	@RequestMapping("/pagaConta")
	public void paga(Long id, HttpServletResponse response) {
		ContaDAO dao = new ContaDAO();
		dao.paga(id);

		response.setStatus(200);

	}

}
