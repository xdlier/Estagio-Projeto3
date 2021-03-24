package compasso.estagio.gabriel.Projeto3.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Moedas {

	private String USD;
	private String EUR;
	private String BTC;
	private String BRL;
	
	public BigDecimal getUSD() {
		return new BigDecimal(this.BRL).divide(new BigDecimal(this.USD), 2, RoundingMode.HALF_UP);
	}
	public void setUSD(String USD) {
		this.USD = USD;
	}
	public BigDecimal getEUR() {
		return new BigDecimal(this.BRL).divide(new BigDecimal(this.EUR), 2, RoundingMode.HALF_UP);
	}
	public void setEUR(String EUR) {
		this.EUR = EUR;
	}
	public BigDecimal getBTC() {
		return new BigDecimal(this.BRL).divide(new BigDecimal(this.BTC), 2, RoundingMode.HALF_UP);
	}
	public void setBTC(String BTC) {
		this.BTC = BTC;
	}
	public BigDecimal getBRL() {
		return new BigDecimal(this.BRL).divide(new BigDecimal(this.BRL), 2, RoundingMode.HALF_UP);
	}
	public void setBRL(String BRL) {
		this.BRL = BRL;
	}
	
}
