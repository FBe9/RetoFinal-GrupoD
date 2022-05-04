package principal;

import gui.*;
import interfaces.EmpleadoControlableBDImplementation;
/**
 * This is the main class for an application managing hospitals.
 * @author Julen
 *
 */
public class Application {
	/**
	 * This method is the entry point for the application
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		//Open main window and show it.
		
		EmpleadoControlableBDImplementation datosE= new EmpleadoControlableBDImplementation();
		CopiaVPrincipal cop = new CopiaVPrincipal(datosE);
		cop.setVisible(true);
		

	}

}