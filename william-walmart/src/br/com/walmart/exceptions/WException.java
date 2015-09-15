package br.com.walmart.exceptions;

/**
 * Exception para o projeto
 *
 * @author William.Galindo
 */
public class WException extends Exception {

	private static final long serialVersionUID = 1L;
	
    public WException() {
        super();
    }

    public WException(String message) {
        super(message);
    }

    public WException(String message, Throwable cause) {
        super(message, cause);
    }

    public WException(Throwable cause) {
        super(cause);
    }

}
