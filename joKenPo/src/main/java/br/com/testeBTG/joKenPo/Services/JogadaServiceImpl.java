package br.com.testeBTG.joKenPo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.testeBTG.joKenPo.DTO.JogadaDTO;
import br.com.testeBTG.joKenPo.Domain.Jogada;
import br.com.testeBTG.joKenPo.Domain.Jogador;
import br.com.testeBTG.joKenPo.Enum.ElementoEnum;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Repository.JogadaRepository;
import br.com.testeBTG.joKenPo.Repository.JogadorRepository;
import br.com.testeBTG.joKenPo.Singleton.JogadaSingleton;

@Service
public class JogadaServiceImpl implements IJogadaService {

	private JogadaRepository jogadaRepo;
	private JogadorRepository jogadorRepo;
	
	
	@Autowired
	public JogadaServiceImpl(JogadaRepository jogadaRepo, JogadorRepository jogadorRepo) {
		this.jogadaRepo = jogadaRepo;
		this.jogadorRepo = jogadorRepo;
	}

	@Override
	public JogadaDTO insert(JogadaDTO jogada) throws JokenpoException {
		if (Objects.isNull(jogada) || StringUtils.isEmpty(jogada.getNomeJogador())
				|| StringUtils.isEmpty(jogada.getJogada())) {
			throw new JokenpoException(new Exception("Jogada Inválida"));
		}

		Jogador jogador = this.jogadorRepo.findByNomeJogador(jogada.getNomeJogador());
		ElementoEnum elemento = ElementoEnum.getNomeElementoEnum(jogada.getJogada().getNome());

		if (Objects.isNull(elemento)) {
			throw new JokenpoException(new Exception("Elemento Não Localizado"));
		}

		Jogada jogadaNova = jogadaRepo.save(new Jogada(jogador, elemento));

		JogadaDTO jogadaDTO = new JogadaDTO(jogadaNova.getJogador().getNome(), jogadaNova.getJogada());

		return jogadaDTO;
	}

	@Override
	public List<JogadaDTO> findAllJogadas() throws JokenpoException {
		List<Jogada> jogadas = this.jogadaRepo.findAll();
		List<JogadaDTO> listaJogadas = new ArrayList<>();
		jogadas.forEach(jogada -> {
			listaJogadas.add(new JogadaDTO(jogada.getJogador().getNome(), jogada.getJogada()));
		});
		return listaJogadas;
	}

	@Override
	public List<JogadaDTO> delete(String nomeJogador) throws JokenpoException {
		if (StringUtils.isEmpty(nomeJogador)) {
			throw new JokenpoException(new Exception("Jogador Inválido"));
		}
		
		Jogada jogada = this.jogadaRepo.findByNomeJogador(nomeJogador);
		
		if(Objects.isNull(jogada)) {
			throw new JokenpoException(new Exception("Erro ao Excluir o Jogador"));
		}
		
		if (this.jogadaRepo.delete(jogada)) {
			return this.findAllJogadas();
		}
				
		throw new JokenpoException(new Exception("Erro ao Excluir o Jogador"));		
	}

	@Override
	public void apagarTodasJogadas() {
		JogadaSingleton.limparJogada();
	}

}
