package principal;

import gui.VentanaPrincipal;
import interfaces.EmpleadoPacineteControlableBDImplementation;
import interfaces.EmpleadosPacienteControlable;
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
		EmpleadosPacienteControlable pacienteControlable = new EmpleadoPacineteControlableBDImplementation();
		
		VentanaPrincipal VentanaPrincipal = new VentanaPrincipal(usuarioLoginControlable, pacienteControlable);
		VentanaPrincipal.setVisible(true);
		

	}

}
