package br.com.testeBTG.Resources;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testeBTG.joKenPo.DTO.JogadorDTO;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Services.JogadorServiceImpl;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
	
	@Autowired
	private JogadorServiceImpl jogadorService;

	public JogadorController() {
	}
	

    @PostMapping(value = "")
    public ResponseEntity<Object> insert(@Valid @RequestBody JogadorDTO jogadorDTO)
            throws JokenpoException {
        return ResponseEntity.ok(this.jogadorService.insert(jogadorDTO));
    }

    @DeleteMapping(value = "")
    public ResponseEntity<Object> delete(@PathParam("nomeJogador") String nomeJogador) throws JokenpoException {
        return ResponseEntity.ok((this.jogadorService.delete(nomeJogador)));
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> findAllJogadores() throws JokenpoException {
        return ResponseEntity.ok(this.jogadorService.findAllJogadores());
    }
	

}
