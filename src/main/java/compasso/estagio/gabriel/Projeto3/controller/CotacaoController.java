package compasso.estagio.gabriel.Projeto3.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import compasso.estagio.gabriel.Projeto3.modelo.LeitorFixer;
import compasso.estagio.gabriel.Projeto3.modelo.MoedasCotadas;

@Controller
public class CotacaoController {

	private String url;

	@RequestMapping("/cotacao")
	public String Cotacao(Model modelo) {
		try {
			url = "http://data.fixer.io/api/latest?access_key=be4781aab7d345a2ea6c476c905d9745&symbols=EUR,USD,BTC,BRL";

			HttpURLConnection conexao = (HttpURLConnection) new URL(url).openConnection();

			conexao.setRequestMethod("GET");
			conexao.setRequestProperty("Accept", "application/json");

			if (conexao.getResponseCode() != 200) {
				JOptionPane.showMessageDialog(null,
						"Erro " + conexao.getResponseCode() + " ao obter dados da URL " + url);
				return null;
			}

			BufferedReader leitor = new BufferedReader(new InputStreamReader((conexao.getInputStream())));

			String saida = "";
			String linha;
			while ((linha = leitor.readLine()) != null) {
				saida += linha;
			}

			conexao.disconnect();

			Gson gson = new Gson();
			LeitorFixer dados = gson.fromJson(new String(saida.getBytes()), LeitorFixer.class);
			MoedasCotadas moedas = new MoedasCotadas(dados.getMoedas().getUSD(), dados.getMoedas().getBRL(),
					dados.getMoedas().getEUR(), dados.getMoedas().getBTC());

			modelo.addAttribute("Euro", "O euro está cotado em " + moedas.getEUR() + "reais");
			modelo.addAttribute("Dolar", "O dólar está cotado em " + moedas.getUSD() + "reais");
			modelo.addAttribute("Bitcoin", "O bitcoin está cotado em " + moedas.getBTC() + "reais");

			return "cotacao";

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
