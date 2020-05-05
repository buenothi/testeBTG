package br.com.testeBTG.joKenPo.Services;

import java.util.ArrayList;
import java.util.List;

import br.com.testeBTG.joKenPo.DTO.JoKenPoDTO;
import br.com.testeBTG.joKenPo.DTO.JogadaDTO;
import br.com.testeBTG.joKenPo.DTO.JogadorDTO;
import br.com.testeBTG.joKenPo.Enum.ElementoEnum;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Singleton.JogadaSingleton;
import br.com.testeBTG.joKenPo.Singleton.JogadorSingleton;

public class JoKenPoServiceImpl implements IJoKenPoService {

	private JogadaServiceImpl jogadaService;
	private JogadorServiceImpl jogadorService;

	@Override
	public JoKenPoDTO jogar() throws JokenpoException {

		List<JogadaDTO> ganhadores = new ArrayList<>();

		this.jogadaService.findAllJogadas().forEach(jogada -> {
			try {
				if (isVencedores(jogada.getJogada().getFraquezas())) {
					ganhadores.add(jogada);
				}
			} catch (JokenpoException jkpex) {

			}
		});

		JoKenPoDTO resultado = new JoKenPoDTO(getVencedoresEJogadas(ganhadores));

		return resultado;
	}
	
	public List<JogadorDTO> reiniciar() throws JokenpoException {
		JogadaSingleton.limparJogada();
		JogadorSingleton.limparJogador();
		return this.jogadorService.findAllJogadores();
	}

	private Boolean isVencedores(List<ElementoEnum> fraquezas) throws JokenpoException {
		for (ElementoEnum elementoEnum : fraquezas) {
			for (JogadorDTO jogada : this.jogadorService.findAllJogadores()) {
				if (jogada.getNome().compareTo(elementoEnum.getNome()) == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private List<String> getVencedoresEJogadas(List<JogadaDTO> jogadasDTO) {
		List<String> resultados = new ArrayList<>();
		for (JogadaDTO jogada : jogadasDTO) {
			String textoResultado = jogada.getNomeJogador() + " (" + jogada.getJogada() + ")";
			resultados.add(textoResultado);
		}
		return resultados;
	}

}
