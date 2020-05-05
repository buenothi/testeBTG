package br.com.testeBTG.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testeBTG.joKenPo.Exception.JokenpoException;
import br.com.testeBTG.joKenPo.Services.JoKenPoServiceImpl;

@RestController
@RequestMapping("/jokenpo")
public class JoKenPoController {
	
	@Autowired
	private JoKenPoServiceImpl joKenPoService;

	public JoKenPoController() {
	}

    @DeleteMapping(value = "")
    public ResponseEntity<Object> delete() throws JokenpoException {
        return ResponseEntity.ok((this.joKenPoService.reiniciar()));
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> jogar() throws JokenpoException {
        return ResponseEntity.ok(this.joKenPoService.jogar());
    }
	

}
