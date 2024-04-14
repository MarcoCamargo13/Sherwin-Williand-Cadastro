package br.com.sher.cadastro.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2280587841410646970L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
