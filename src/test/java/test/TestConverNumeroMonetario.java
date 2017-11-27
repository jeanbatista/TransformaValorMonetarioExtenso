package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConverNumeroMonetario {
	
	ValorMonetario valorMonetario = new ValorMonetario();
	
	@Test
	public void testDezena() {
		String valor = "42,00";
		String result = this.valorMonetario.convert(valor);
		assertEquals("Quarenta e Dois", result);
	}
	@Test
	public void testValorInvalido() {
		String valor = "13,92";
		String result = this.valorMonetario.convert(valor);
		assertEquals("Valor inválido", result);
	}
	@Test
	public void testNumeroNegativo() {
		String valor = "-23,00";
		String result = this.valorMonetario.convert(valor);
		System.out.println(result);
		assertEquals("Valor inválido", result);
	}
	@Test
	public void testNumeroQuatroDigito() {
		String valor = "1456,00";
		String result = this.valorMonetario.convert(valor);
		assertEquals("Valor inválido", result);
	}
	@Test
	public void testUnidade() {
		String valor = "2,00";
		String result = this.valorMonetario.convert(valor);
		assertEquals("Dois", result);
	}
	@Test
	public void testCentena() {
		String valor = "678,00";
		String result = this.valorMonetario.convert(valor);
		assertEquals("Seiscentos e Setenta e Nove", result);
	}

}
