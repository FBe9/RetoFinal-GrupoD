package exceptions;

import java.sql.SQLException;

public class CreateSqlException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateSqlException() {
	
	super();
		
	}
	
	public CreateSqlException(String message) {
		
	super(message);
		
	}
	
	
	
}
