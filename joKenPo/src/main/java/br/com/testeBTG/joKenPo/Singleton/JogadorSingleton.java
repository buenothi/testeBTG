package br.com.testeBTG.joKenPo.Singleton;

import java.util.ArrayList;
import java.util.List;

import br.com.testeBTG.joKenPo.Domain.Jogador;

public final class JogadorSingleton {

	private static List<Jogador> INSTANCE;

	public JogadorSingleton() {
	}

	public static List<Jogador> getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ArrayList<Jogador>();
		}
		return INSTANCE;
	}
	
	public static List<Jogador> limparJogador() {
		INSTANCE = new ArrayList<Jogador>();
		return getInstance();
	}

}
