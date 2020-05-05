package br.com.testeBTG.joKenPo.Services;

import java.util.List;

import br.com.testeBTG.joKenPo.DTO.JogadorDTO;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;

public interface IJogadorService {
	
	JogadorDTO insert(JogadorDTO jogador) throws JokenpoException;
	
	List<JogadorDTO> findAllJogadores() throws JokenpoException;
	
	List<JogadorDTO> delete(String nomeJogador) throws JokenpoException;
	
	void apagarTodosJogadores();

}
