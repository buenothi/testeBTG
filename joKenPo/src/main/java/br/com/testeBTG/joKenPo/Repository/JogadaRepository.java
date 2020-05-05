package br.com.testeBTG.joKenPo.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import br.com.testeBTG.joKenPo.Domain.Jogada;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Singleton.JogadaSingleton;

@Repository
@NoRepositoryBean
public class JogadaRepository {

	public Jogada save(Jogada jogada) throws JokenpoException {

		if (JogadaSingleton.getInstance() != null && JogadaSingleton.getInstance().add(jogada)) {
			return jogada;
		}
		
		throw new JokenpoException(new Exception("Erro ao Salvar Jogada"));

	}

	public boolean delete(Jogada jogada) throws JokenpoException {

		if (JogadaSingleton.getInstance() != null) {
			return JogadaSingleton.getInstance().remove(jogada);
		}

		throw new JokenpoException(new Exception("Erro ao Excluir Jogada"));

	}

	public List<Jogada> findAll() throws JokenpoException {
		
		if (JogadaSingleton.getInstance() != null) {
			return JogadaSingleton.getInstance();
		}
		
		throw new JokenpoException(new Exception("Erro ao Listar Jogadas"));
		
	}

	public Jogada findByNomeJogador(String nomeJogador) throws JokenpoException {
		
		List<Jogada> list = findAll().stream()
				.filter(elem -> (elem.getJogador().getNome().compareToIgnoreCase(nomeJogador) == 0))
				.collect(Collectors.toList());
		
		Optional<Jogada> optional = list.stream().findFirst();
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		throw new JokenpoException(new Exception("Erro ao Localizar Jogador"));
	}

}
