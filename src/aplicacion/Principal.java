package aplicacion;

import vista.PVMain;
import modelo.CochePropietarioControlador;
import modelo.CochePropietarioControladorBD;


public class Principal {

	public static void main(String[] args) {
		// 
		CochePropietarioControlador datos = new CochePropietarioControladorBD();
		
		//Pantalla inicial
		PVMain ventanaPrincipal = new PVMain(datos);
		ventanaPrincipal.setVisible(true);
	}

}
