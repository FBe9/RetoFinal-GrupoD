package principal;

import gui.VentanaPrincipal;
import interfaces.DepartamentoControlable;
import interfaces.DepartamentoControlableBDImplementation;
import interfaces.EmpleadoControlable;
import interfaces.EmpleadoControlableBDImplementation;
import interfaces.EmpleadoPacineteControlableBDImplementation;
import interfaces.EmpleadosPacienteControlable;

/**
 * @author Julen
 * Esta es la class primaria y desde la que se ejecuta la clase 'VentanaPrincipal'.
 */
public class Application {
	/**
	 * Este metodo crea la entrada a la aplicación.
	 */
	public static void main(String[] args) {
		//Abre la ventana principal y la muestra.

		EmpleadoControlable empleadoControlable = new EmpleadoControlableBDImplementation();
		EmpleadosPacienteControlable pacienteControlable = new EmpleadoPacineteControlableBDImplementation();
		DepartamentoControlable departamentoControlable = new DepartamentoControlableBDImplementation();
    
		VentanaPrincipal VentanaPrincipal = new VentanaPrincipal(empleadoControlable, pacienteControlable, departamentoControlable);

		VentanaPrincipal.setVisible(true);
		

	}

}
