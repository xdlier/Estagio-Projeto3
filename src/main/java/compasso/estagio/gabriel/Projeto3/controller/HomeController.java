package compasso.estagio.gabriel.Projeto3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import compasso.estagio.gabriel.Projeto3.modelo.LeitorFixer;
import compasso.estagio.gabriel.Projeto3.modelo.UtilizadorAPI;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model modelo) {
		LeitorFixer dados = UtilizadorAPI.modelador(modelo);
		modelo.addAttribute("Euro", dados.getMoedas().getEUR());
		modelo.addAttribute("Dolar", dados.getMoedas().getUSD());
		modelo.addAttribute("Bitcoin", dados.getMoedas().getBTC());
		return "index";
	}
}
