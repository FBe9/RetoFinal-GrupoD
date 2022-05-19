package exceptions;

	/**
	 * Esta clase tiene un constructor que recojera un mensaje especifico que quieras, se utilizan para que el usuario sea informado de los mensajes de error sobre la BD.
	 * @author 1dami
	 */

public class CreateSqlException extends Exception {
	 
	 
	private static final long serialVersionUID = 1L;

	public CreateSqlException() {
	
	super();
		
	}
	
	/**
	 * Metodo con que recibe un mensaje.
	 * @param message
	 */
	
	public CreateSqlException(String message) {
		
	super(message);
		
	}
	
	
	
}