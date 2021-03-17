package compasso.estagio.gabriel.Projeto3.modelo;

public class MoedasCotadas {

	private String USD, BRL, EUR, BTC;

	public MoedasCotadas(String USD, String BRL, String EUR, String BTC) {
		ConversorInt(USD, BRL, EUR, BTC);
	}

	private void ConversorInt(String USD, String BRL, String EUR, String BTC) {

		double BR = 0;
		double EUA = 0;
		double Bit = 0;
		double exp = 0;

		for (int i = 0; i < BRL.length(); i++) {
			if (i != 1) {
				BR += (BRL.charAt(i) - 48) * Math.pow(10, -exp);
				exp++;
			}
		}
		exp = 0;
		for (int i = 0; i < USD.length(); i++) {
			if (i != 1) {
				EUA += (USD.charAt(i) - 48) * Math.pow(10, -exp);
				exp++;
			}
		}
		exp = 0;
		for (int i = 0; i < BTC.length(); i++) {
			if (BTC.charAt(i) == 'e') {
				if (BTC.charAt(i + 1) == '-') {
					exp = BTC.charAt(i + 2) - 48;
					break;
				}
			} else {
				if (i != 1) {
					Bit += (BTC.charAt(i) - 48) * Math.pow(10, -exp);
					exp++;
				}
			}
		}

		this.BRL = "1";
		EUA = BR / EUA;
		Bit = (BR / Bit) * Math.pow(10, exp);
		this.USD = String.valueOf(EUA);
		this.EUR = BRL;
		this.BTC = String.valueOf(Bit);
	}

	public String getUSD() {
		return USD;
	}

	public String getBRL() {
		return BRL;
	}

	public String getEUR() {
		return EUR;
	}

	public String getBTC() {
		return BTC;
	}

}
