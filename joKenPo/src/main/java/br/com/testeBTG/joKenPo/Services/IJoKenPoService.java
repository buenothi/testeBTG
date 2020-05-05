package br.com.testeBTG.joKenPo.Services;

import java.util.List;

import br.com.testeBTG.joKenPo.DTO.JoKenPoDTO;
import br.com.testeBTG.joKenPo.DTO.JogadorDTO;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;

public interface IJoKenPoService {
	
	JoKenPoDTO jogar() throws JokenpoException;
	
	List<JogadorDTO> reiniciar() throws JokenpoException ;

}
