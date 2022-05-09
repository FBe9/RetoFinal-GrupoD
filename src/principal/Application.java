package principal;

import gui.VentanaPrincipal;
import interfaces.DepartamentoControlable;
import interfaces.DepartamentoControlableBDImplementation;
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
		DepartamentoControlable departamentoControlable = new DepartamentoControlableBDImplementation();
		
		VentanaPrincipal VentanaPrincipal = new VentanaPrincipal(usuarioLoginControlable, departamentoControlable);
		VentanaPrincipal.setVisible(true);
		

	}

}
