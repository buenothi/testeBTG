package br.com.testeBTG.joKenPo.Exception;

public class JokenpoException extends Exception {

	private static final long serialVersionUID = 1L;

	public JokenpoException(Exception exception){
        super(exception.getMessage());
    }
}
