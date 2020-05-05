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

import br.com.testeBTG.joKenPo.DTO.JogadaDTO;
import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Services.JogadaServiceImpl;

@RestController
@RequestMapping("/jogada")
public class JogadaController {
	
	@Autowired
	private JogadaServiceImpl jogadaService;

	public JogadaController() {
	}
	

    @PostMapping(value = "")
    public ResponseEntity<Object> insert(@Valid @RequestBody JogadaDTO jogadaDTO)
            throws JokenpoException {
        return ResponseEntity.ok(this.jogadaService.insert(jogadaDTO));
    }

    @DeleteMapping(value = "")
    public ResponseEntity<Object> delete(@PathParam("nomeJogador") String nomeJogador) throws JokenpoException {
        return ResponseEntity.ok((this.jogadaService.delete(nomeJogador)));
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> gefindAllJogadores() throws JokenpoException {
        return ResponseEntity.ok(this.jogadaService.findAllJogadas());
    }
	

}
