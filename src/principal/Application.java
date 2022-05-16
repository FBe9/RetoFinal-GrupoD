package principal;

import clases.Departamento;
import gui.VentanaPrincipal;
import interfaces.DepartamentoControlable;
import interfaces.DepartamentoControlableBDImplementation;
import interfaces.EmpleadoControlable;
import interfaces.EmpleadoControlableBDImplementation;
import interfaces.EmpleadoPacineteControlableBDImplementation;
import interfaces.EmpleadosPacienteControlable;
import jUnit.DepartamentoControlableBDImplementationTest;

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
		DepartamentoControlable departamentoControlable = new DepartamentoControlableBDImplementation();
    
		VentanaPrincipal VentanaPrincipal = new VentanaPrincipal(empleadoControlable, pacienteControlable, departamentoControlable);

		VentanaPrincipal.setVisible(true);
		

	}

}
