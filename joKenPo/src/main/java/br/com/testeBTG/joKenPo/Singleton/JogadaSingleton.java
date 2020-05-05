package br.com.testeBTG.joKenPo.Singleton;

import java.util.ArrayList;
import java.util.List;

import br.com.testeBTG.joKenPo.Domain.Jogada;

public final class JogadaSingleton {

	private static List<Jogada> INSTANCE;

	public JogadaSingleton() {
	}

	public static List<Jogada> getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ArrayList<Jogada>();
		}
		return INSTANCE;
	}
	
	public static List<Jogada> limparJogada() {
		INSTANCE = new ArrayList<Jogada>();
		return getInstance();
	}

}
