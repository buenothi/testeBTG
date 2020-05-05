package br.com.testeBTG.joKenPo.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import br.com.testeBTG.joKenPo.Domain.Jogador;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Singleton.JogadorSingleton;

@Repository
@NoRepositoryBean
public class JogadorRepository {

	public Jogador save(Jogador jogador) throws JokenpoException {

		if (JogadorSingleton.getInstance() != null && JogadorSingleton.getInstance().add(jogador)) {
			return jogador;
		}
		
		throw new JokenpoException(new Exception("Erro ao Salvar Jogador"));

	}

	public boolean delete(Jogador jogador) throws JokenpoException {

		if (JogadorSingleton.getInstance() != null) {
			return JogadorSingleton.getInstance().remove(jogador);
		}

		throw new JokenpoException(new Exception("Erro ao Excluir Jogador"));

	}

	public List<Jogador> findAll() throws JokenpoException {
		
		if (JogadorSingleton.getInstance() != null) {
			return JogadorSingleton.getInstance();
		}
		
		throw new JokenpoException(new Exception("Erro ao Listar Jogadores"));
		
	}

	public Jogador findByNomeJogador(String nomeJogador) throws JokenpoException {
		
		List<Jogador> list = findAll().stream()
				.filter(elem -> (elem.getNome().compareToIgnoreCase(nomeJogador) == 0))
				.collect(Collectors.toList());
		
		Optional<Jogador> optional = list.stream().findFirst();
		
		if (optional.isPresent()) {
			return optional.get();
		}
		
		throw new JokenpoException(new Exception("Erro ao Localizar Jogador"));
	}

}
