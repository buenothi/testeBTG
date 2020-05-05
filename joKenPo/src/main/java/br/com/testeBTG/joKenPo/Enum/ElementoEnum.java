package br.com.testeBTG.joKenPo.Enum;

import java.util.Arrays;
import java.util.List;

import br.com.testeBTG.joKenPo.Exception.JokenpoException;

public enum ElementoEnum {
	TESOURA("TESOURA"), PAPEL("PAPEL"), PEDRA("PEDRA"), LAGARTO("LAGARTO"), SPOCK("SPOCK");

	private ElementoEnum(String nome) {
		this.nome = nome;
	}

	private String nome;

	private List<ElementoEnum> fraquezas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ElementoEnum> getFraquezas() {
		return fraquezas;
	}

	public void setFraquezas(List<ElementoEnum> fraquezas) {
		this.fraquezas = fraquezas;
	}
	
	static {
		TESOURA.setFraquezas(Arrays.asList(PEDRA, SPOCK));
		PAPEL.setFraquezas(Arrays.asList(LAGARTO, TESOURA));
		PEDRA.setFraquezas(Arrays.asList(PAPEL, SPOCK));
		LAGARTO.setFraquezas(Arrays.asList(TESOURA, PEDRA));
		SPOCK.setFraquezas(Arrays.asList(PAPEL, LAGARTO));
	}
	
	public static ElementoEnum getNomeElementoEnum(String name) throws JokenpoException {
        for (ElementoEnum  elemento : Arrays.asList(ElementoEnum .values())) {
            if (name.equals(elemento.getNome())) {
                return elemento;
            }
        }
        throw new JokenpoException(new Exception("Erro ao Adicionar Elemento"));
    }

}
