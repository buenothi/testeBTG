package br.com.testeBTG.joKenPo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.testeBTG.joKenPo.DTO.JogadorDTO;
import br.com.testeBTG.joKenPo.Domain.Jogador;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Repository.JogadorRepository;
import br.com.testeBTG.joKenPo.Singleton.JogadorSingleton;

@Service
public class JogadorServiceImpl implements IJogadorService {

	private JogadorRepository jogadorRepo;
	private JogadaServiceImpl jogadaService;

	@Autowired
	public JogadorServiceImpl(JogadorRepository jogadorRepo, JogadaServiceImpl jogadaService) {
		this.jogadorRepo = jogadorRepo;
		this.jogadaService = jogadaService;
	}

	@Override
	public JogadorDTO insert(JogadorDTO jogador) throws JokenpoException {
		Jogador jogadorNovo = new Jogador(jogador.getNome());
		if (!Objects.isNull(this.jogadorRepo.findByNomeJogador(jogador.getNome()))) {
			return new JogadorDTO(jogadorNovo.getNome());
		} else {
			throw new JokenpoException(new Exception("Erro ao Inserir Jogador"));
		}
	}

	@Override
	public List<JogadorDTO> findAllJogadores() throws JokenpoException {
		List<Jogador> jogadores = this.jogadorRepo.findAll();
		List<JogadorDTO> jogadoresDTO = new ArrayList<>();
		jogadores.forEach(jogador -> {
			jogadoresDTO.add(new JogadorDTO(jogador.getNome()));
		});
		return jogadoresDTO;
	}

	@Override
	public List<JogadorDTO> delete(String nomeJogador) throws JokenpoException {
		if (StringUtils.isEmpty(nomeJogador)) {
			throw new JokenpoException(new Exception("Erro ao Deletar Jogador!"));
		}

		try {
			this.jogadaService.delete(nomeJogador);
		} catch (JokenpoException jkpex) {
			throw jkpex;
		}

		Jogador jogador = this.jogadorRepo.findByNomeJogador(nomeJogador);

		if (this.jogadorRepo.delete(jogador)) {
			return this.findAllJogadores();
		} else {
			throw new JokenpoException(new Exception("Erro ao Deletar Jogador!"));
		}
	}

	@Override
	public void apagarTodosJogadores() {
		JogadorSingleton.limparJogador();
	}

}
