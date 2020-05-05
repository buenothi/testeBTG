package br.com.testeBTG.joKenPo.Domain;

import java.io.Serializable;

import javax.persistence.Entity;

import br.com.testeBTG.joKenPo.Enum.ElementoEnum;

@Entity
public class Jogada implements Serializable {

	private static final long serialVersionUID = 1L;

	private Jogador jogador;
	private ElementoEnum jogada;

	public Jogada() {
	}

	public Jogada(Jogador jogador, ElementoEnum jogada) {
		this.jogador = jogador;
		this.jogada = jogada;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public ElementoEnum getJogada() {
		return jogada;
	}

	public void setJogada(ElementoEnum jogada) {
		this.jogada = jogada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogada == null) ? 0 : jogada.hashCode());
		result = prime * result + ((jogador == null) ? 0 : jogador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogada other = (Jogada) obj;
		if (jogada != other.jogada)
			return false;
		if (jogador == null) {
			if (other.jogador != null)
				return false;
		} else if (!jogador.equals(other.jogador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jogada [jogada=" + jogada + "]";
	}

}
