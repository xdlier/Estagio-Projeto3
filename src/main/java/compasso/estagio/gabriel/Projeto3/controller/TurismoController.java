package compasso.estagio.gabriel.Projeto3.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import compasso.estagio.gabriel.Projeto3.modelo.LeitorFixer;
import compasso.estagio.gabriel.Projeto3.modelo.UtilizadorAPI;

@Controller
public class TurismoController {

	@RequestMapping("/turismo")
	public String Turismo(Model modelo) {
		LeitorFixer dados = UtilizadorAPI.modelador(modelo);
		modelo.addAttribute("Data", dados.getDate());
		modelo.addAttribute("Euro", dados.getMoedas().getEUR().multiply(new BigDecimal(1.035), MathContext.DECIMAL32)
				.divide(new BigDecimal(1), 2, RoundingMode.UP));
		modelo.addAttribute("Dolar", dados.getMoedas().getUSD().multiply(new BigDecimal(1.035), MathContext.DECIMAL32)
				.divide(new BigDecimal(1), 2, RoundingMode.UP));
		modelo.addAttribute("Bitcoin", dados.getMoedas().getBTC());
		return "Cotacao";
	}

}
