package principal;

import gui.VentanaPrincipal;
import interfaces.EmpleadoControlable;
import interfaces.EmpleadoControlableBDImplementation;
import interfaces.EmpleadoPacineteControlableBDImplementation;
import interfaces.EmpleadosPacienteControlable;

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

		EmpleadoControlable empleadoControlable = new EmpleadoControlableBDImplementation();
		EmpleadosPacienteControlable pacienteControlable = new EmpleadoPacineteControlableBDImplementation();
    
		VentanaPrincipal VentanaPrincipal = new VentanaPrincipal(empleadoControlable, pacienteControlable);

		VentanaPrincipal.setVisible(true);
		

	}

}
