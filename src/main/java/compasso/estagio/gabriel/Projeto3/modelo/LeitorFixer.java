package compasso.estagio.gabriel.Projeto3.modelo;

public class LeitorFixer {

	private String success, timestamp, base, date;
	private Moedas rates;
	
	public LeitorFixer() {
		rates = new Moedas();
	}
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Moedas getMoedas() {
		return rates;
	}
	public void setMoedas(Moedas moedas) {
		this.rates = moedas;
	}
	
	
}
