package com.andre.selenium.testes.brasileirao;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.andre.selenium.SeleniumTeste;
import com.andre.selenium.SeleniumWebDriver;
import com.andre.selenium.telas.brasileirao.TelaTabelaBrasileirao;
import com.andre.selenium.telas.brasileirao.Times;

public class CampeonatoBrasileiroTestes extends SeleniumTeste {

	TelaTabelaBrasileirao telaBrasileiro;
	SeleniumWebDriver selenium;

	@Before
	public void prepararBrasileiro() {
		this.selenium = new SeleniumWebDriver(driver);
		this.telaBrasileiro = new TelaTabelaBrasileirao(selenium);
		this.telaBrasileiro.abrir();
	}

	@Test
	public void testarClassificadosLibertadores() {
		ArrayList<String> classificados = telaBrasileiro
				.getEstatisticasTimeLibertadores();
		for (int i = 0; i < classificados.size(); i++) {
			System.out.println(classificados.get(i));
		}

	}

	private void consultas() {
		ArrayList classificados = telaBrasileiro
				.getEstatisticasTimeLibertadores();
		for (int i = 0; i < classificados.size(); i++) {
			Times t = (Times) classificados.get(i);
			if (t.getTime().toLowerCase().endsWith("palmeiras")) {
				System.out.println("Classificação do Palmeiras: " + (i + 1)
						+ "°\n");
				if (i > 15) {
					System.out
							.println("O Palmeiras será rebaixado a Série B\n");
				}
			}
			if (i >= 16) {
				System.out.println("Clube rebaixado para Série B:\n"
						+ classificados.get(i));
			}
		}
	}

	@Test
	public void testarRebaixadosLibertadores() {
		ArrayList<String> rebaixados = telaBrasileiro
				.getEstatisticaTimesRebaixados();

		System.out.println(rebaixados);
	}

	@Test
	public void testarPalmeiras() {
		ArrayList<String> palmeiras = telaBrasileiro.getPalmeiras();
		System.out.print(palmeiras);
	}

	@Test
	public void testarCorinthians() {
		ArrayList<String> cori = telaBrasileiro.getCorinthians();
		System.out.print(cori);
	}

}