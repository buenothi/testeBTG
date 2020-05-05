package br.com.testeBTG.joKenPo.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.testeBTG.joKenPo.Enum.ElementoEnum;

public class JogadaDTO {

	@Size(min = 1)
	@NotNull(message = "Jogador é Obrigatório")
	private String nomeJogador;

	@Size(min = 1)
	@NotNull(message = "Jogada é Obrigatório")
	private ElementoEnum jogada;

	public JogadaDTO() {
	}

	public JogadaDTO(String nomeJogador, ElementoEnum jogada) {
		this.nomeJogador = nomeJogador;
		this.jogada = jogada;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
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
		result = prime * result + ((nomeJogador == null) ? 0 : nomeJogador.hashCode());
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
		JogadaDTO other = (JogadaDTO) obj;
		if (jogada != other.jogada)
			return false;
		if (nomeJogador == null) {
			if (other.nomeJogador != null)
				return false;
		} else if (!nomeJogador.equals(other.nomeJogador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JogadaDTO [nomeJogador=" + nomeJogador + ", jogada=" + jogada + "]";
	}

}
