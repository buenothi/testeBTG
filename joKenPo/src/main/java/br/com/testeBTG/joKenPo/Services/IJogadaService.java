package br.com.testeBTG.joKenPo.Services;

import java.util.List;

import br.com.testeBTG.joKenPo.DTO.JogadaDTO;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;

public interface IJogadaService {
	
	JogadaDTO insert(JogadaDTO jogada) throws JokenpoException;
	
	List<JogadaDTO> findAllJogadas() throws JokenpoException;
	
	List<JogadaDTO> delete(String nomeJogador) throws JokenpoException;
	
	void apagarTodasJogadas();

}
