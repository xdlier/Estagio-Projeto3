package compasso.estagio.gabriel.Projeto3.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JOptionPane;

import org.springframework.ui.Model;

import com.google.gson.Gson;

public class UtilizadorAPI {
	
	public static LeitorFixer modelador(Model modelo) {
		LeitorFixer dados = null;
		try {

			HttpURLConnection conexao = (HttpURLConnection) new URL(
					"http://data.fixer.io/api/latest?access_key=be4781aab7d345a2ea6c476c905d9745&symbols=EUR,USD,BTC,BRL")
							.openConnection();

			conexao.setRequestMethod("GET");
			conexao.setRequestProperty("Accept", "application/json");

			if (conexao.getResponseCode() != 200) {
				JOptionPane.showMessageDialog(null, "Erro " + conexao.getResponseCode() + " ao obter dados da URL "
						+ "http://data.fixer.io/api/latest?access_key=be4781aab7d345a2ea6c476c905d9745&symbols=EUR,USD,BTC,BRL");
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
			dados = gson.fromJson(new String(saida.getBytes()), LeitorFixer.class);


		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return dados;
	}
}
