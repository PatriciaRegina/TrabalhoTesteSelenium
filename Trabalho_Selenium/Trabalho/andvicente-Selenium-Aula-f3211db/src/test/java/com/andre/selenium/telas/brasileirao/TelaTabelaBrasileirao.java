package com.andre.selenium.telas.brasileirao;

import java.util.ArrayList;

import com.andre.selenium.SeleniumWebDriver;

public class TelaTabelaBrasileirao {

	private SeleniumWebDriver selenium;
	private static final String URL = "http://esporte.uol.com.br/futebol/campeonatos/brasileiro/2012/serie-a/classificacao/classificacao.htm";

	public TelaTabelaBrasileirao(SeleniumWebDriver selenium) {
		this.selenium = selenium;
	}

	public void abrir() {
		selenium.driver.get(URL);
		selenium.assertTitle("Classificação do Campeonato Brasileiro 2012 de Futebol - UOL Esporte");
	}

	public ArrayList<String> getEstatisticasTimeLibertadores() {
		ArrayList<String> times = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			times.add(selenium.getTextTableCell("classificationTable", i, 1));
		}
		return times;
	}

	public ArrayList<String> getEstatisticaTimesRebaixados() {
		ArrayList<String> times = new ArrayList<String>();
		for (int i = 20; i >= 17; i--) {
			times.add(selenium.getTextTableCell("classificationTable", i, 1));
		}
		return times;

	}

	public ArrayList<String> getPalmeiras() {
		ArrayList<String> a = new ArrayList<>();
		ArrayList<Times> classificados = new ArrayList<Times>();
		for (int i = 0; i < classificados.size(); i++) {
			Times t = (Times) classificados.get(i);
			if (t.getTime().toLowerCase().endsWith("palmeiras")) {
				a.add(selenium.getTextTableCell("classificationTable", i, 1));
				if (i > 15) {
					System.out
							.println("O Palmeiras será rebaixado a Série B\n");
				}
			}

		}
		return a;
	}

	public ArrayList<String> getCorinthians() {
		ArrayList<String> a = new ArrayList<>();
		ArrayList<Times> classificados = new ArrayList<Times>();
		for (int i = 0; i < classificados.size(); i++) {
			Times t = (Times) classificados.get(i);
			a.add(selenium.getTextTableCell("classificationTable", i, 1));
			if (t.getTime().toLowerCase().endsWith("corinthias")) {
				System.out.println("Classificação do Timão: " + (i + 1)
						+ "°, com " + t.getPg() + " pontos");

			}
		}

		return a;
	}

}