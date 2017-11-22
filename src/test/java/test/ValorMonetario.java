package test;

public class ValorMonetario {
	private final String VALOR_INVALIDO = "Valor inválido";
	
	public String unidade(int valor) {
		String result;
		switch (valor) {
			case 1:
				result = "Um";
				break;
			case 2:
				result = "Dois";
				break;
			case 3:
				result = "Três";
				break;
			case 4:
				result = "Quatro";
				break;
			case 5:
				result = "Cinco";
				break;
			case 6:
				result = "Seis";
				break;
			case 7:
				result = "Sete";
				break;
			case 8:
				result = "Oito";
				break;
			case 9:
				result = "Nove";
				break;		
			default:
				result = "Valor Inválido";
				break;
			}
		
		return result;
	}
	
	public String onzeADezenove(int valor) {
		String result;
		
		switch (valor) {
			case 11:
				result = "Onze";
				break;
			case 12:
				result = "Doze";
				break;
			case 13:
				result = "Treze";
				break;
			case 14:
				result = "Quatorze";
				break;
			case 15:
				result = "Quinze";
				break;
			case 16:
				result = "Dezesseis";
				break;
			case 17:
				result = "Dezessete";
				break;
			case 18:
				result = "Dezoito";
				break;
			case 19:
				result = "Dezenove";
				break;
			default:
				result = "Valor Inválido";
				break;
			}
		
		return result;
	}
	
	public String decimalCompleto(int valor) {
		String result;
		
		switch (valor) {
			case 10:
				result = "Dez";
				break;
			case 20:
				result = "Vinte";
				break;
			case 30:
				result = "Trinta";
				break;
			case 40:
				result = "Quarenta";
				break;
			case 50:
				result = "Cinquenta";
				break;
			case 60:
				result = "Sessenta";
				break;
			case 70:
				result = "Setenta";
				break;
			case 80:
				result = "Oitenta";
				break;
			case 90:
				result = "Noventa";
				break;
			default:
				result = "Número Inválido";
				break;
			}
		
		return result;
	}
	
	public String numeroCentena(int valor) {
		String result;
		
		switch (valor) {
			case 100:
				result = "Cem";
				break;
			case 200:
				result = "Duzentos";
				break;
			case 300:
				result = "Trezentos";
				break;
			case 400:
				result = "Quatrocentos";
				break;
			case 500:
				result = "Quinhentos";
				break;
			case 600:
				result = "Seiscentos";
				break;
			case 700:
				result = "Setecentos";
				break;
			case 800:
				result = "Oitocentos";
				break;
			case 900:
				result = "Novecentos";
				break;
			default:
				result = "Valor inválido";
		}
		
		return result;
	}
	
	private String numeroCem() {
		return "Cento";
	}
	
	private String numeroVinteACem(int num) {
		String result;
		int num2 = Integer.parseInt(String.valueOf(num).substring(1));
		if (num2 == 0) {
			result = this.decimalCompleto(num);
		} else {
			int num1 = Integer.parseInt(String.valueOf(num).substring(0,1));
			String zero = "0";
			String decimalText = this.decimalCompleto(Integer.parseInt(String.valueOf(num1) + zero));
			String unidadeText = this.unidade(num2);
			result = decimalText + " e " + unidadeText;
		}
		
		return result;
	}
	
	private String numeroCemAMil(int num) {
		String result;
		
		int num1 = Integer.parseInt(String.valueOf(num).substring(0, 1));
		int num2 = Integer.parseInt(String.valueOf(num).substring(1, 2));
		int num3 = Integer.parseInt(String.valueOf(num).substring(2));
		
		if (num2 == 0 && num3 == 0) {
			result = this.numeroCentena(num);
		} else if (num1 == 1) {
			result = this.numeroCem();

		} else {
			result = this.numeroCentena(Integer.parseInt(String.valueOf(num1) + "00"));
		}
		
		String num2Aux = String.valueOf(num2);
		String num3Aux = String.valueOf(num3);
		int numDecimalAux = Integer.parseInt(num2Aux + num3Aux);
				
		if (num3 == 0) {
			result += this.decimalCompleto(Integer.parseInt(String.valueOf(num2) + "0"));
		} else if (numDecimalAux > 10 && numDecimalAux < 20) {
			result += " e " + this.onzeADezenove(numDecimalAux);
		} else {
			String zero = "0";
			String decimalText = this.decimalCompleto(Integer.parseInt(String.valueOf(num2Aux) + zero));
			String unidadeText = this.unidade(num3);
			
			result += " e " + decimalText + " e " + unidadeText;
		}
		
		return result;
	}
	
	public String convert(String valor) {
		String result = "";
		
		String[] valorAux = valor.split(",");
		int numDecimal = Integer.parseInt(valorAux[1]);
		if (numDecimal == 0) {
			int numero = Integer.parseInt(valorAux[0]);
			if (numero > 0 && numero < 1000) {
				result = this.getNumeroExtenso(numero);
			} else {
				result = this.VALOR_INVALIDO;
			}
		} else {
			result = this.VALOR_INVALIDO;
		}
		
		return result;
	}
	
	private String getNumeroExtenso(int num) {
		String result;
		
		char[] digitos = String.valueOf(num).toCharArray();
		
		if (num > 0 && num < 10) {
			result = this.unidade(num);
		} else if (num > 10 && num < 20) {
			result = this.onzeADezenove(num);
		} else if (digitos.length == 2) {
			result = this.numeroVinteACem(num);
		} else if (digitos.length == 3) {
			result = this.numeroCemAMil(num);
		} else {
			result = this.VALOR_INVALIDO;
		}
		return result;
	}
}
