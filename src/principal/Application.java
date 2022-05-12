package principal;

import gui.VentanaPrincipal;
import interfaces.EmpleadoControlable;
import interfaces.EmpleadoControlableBDImplementation;
import interfaces.UsuarioLoginControlable;
import interfaces.UsuarioLoginControlableBDImplementation;
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

		UsuarioLoginControlable usuarioLoginControlable = new UsuarioLoginControlableBDImplementation();
		EmpleadoControlable empleadoControlable = new EmpleadoControlableBDImplementation();
		
		VentanaPrincipal VentanaPrincipal = new VentanaPrincipal(usuarioLoginControlable, empleadoControlable);
		VentanaPrincipal.setVisible(true);
		

	}

}
