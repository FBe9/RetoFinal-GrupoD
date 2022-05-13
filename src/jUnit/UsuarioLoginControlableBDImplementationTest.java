package jUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Usuario;
import gui.VentanaAdminGestionDepartamentoYEmpleado;

public class UsuarioLoginControlableBDImplementationTest {
	
	Connection conexion;
	PreparedStatement psttm;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Con este metodo testeamos si la conexion con la base de datos funciona correctamente
	 */

	/*@Test
	public void openConnectionTest() {
		try {
			// String url = "jdbc:mysql://localhost/nombreBaseDatos";
			String url = "jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";
			// con = DriverManager.getConnection(url+"?" +"user=____&password=_____");
			conexion = DriverManager.getConnection(url, "root", "abcd*1234");
		} catch (SQLException e) {
			
		}
	}*/
	
	/*@Test
	public void buscarDepartamentoTest() {
		String codigoDelUsuario = "Admin", contrasenaDelUsuario = "abcd*1234";
		Usuario usuario;
		boolean usuarioencontrado = false;
		
		UsuarioLoginControlableBDImplementation login = new UsuarioLoginControlableBDImplementation();
		usuario = login.loginUsuario(codigoDelUsuario, contrasenaDelUsuario);
		
		if(!(codigoDelUsuario.isEmpty() && contrasenaDelUsuario.isEmpty())) {
			if(usuario != null) {
				usuarioencontrado = true; 
			}else {
			}
		}else {
		}
	}
	*/

}
