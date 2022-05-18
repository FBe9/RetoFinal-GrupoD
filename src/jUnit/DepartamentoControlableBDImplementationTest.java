package jUnit;


import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.After;
import org.junit.Before;

/**
 * Clase en el que se testean todos los metodos que se implementan de la interfaz seleccionada.
 * @author Julen
 *
 */

public class DepartamentoControlableBDImplementationTest {
	
	Connection conexion;
	PreparedStatement psttm;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Con este metodo testeamos si la conexion con la base de datos funciona correctamente.
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
	}
	
	/**
	 * Con este metodo testeamos el alta de un departamento en la base de datos.
	 */
	
	/*@Test 
	public void añadirDepartamentoTest() { 
		
		String[] especialidades = new String[] {"a","a","a","a","a"};
		
		Departamento depart = new Departamento("CD004", "a", true, especialidades);
		  
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.añadirDepartamento(depart);
		  
	}
	
	/**
	 * Con este metodo testeamos la modificacion de un departamento en la base de datos.
	 */
	
	/*@Test
	public void modificarDepartamentoTest() {
		
		String[] especialidades = new String[] {"b","b","b","b","b"};
		
		Departamento depart = new Departamento("CD004", "a", true, especialidades);
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.modificarDepartamento(depart);

	}
	
	/**
	 * Con este metodo testeamos la eliminacion de un departamento en la base de datos.
	 */
	
	/*@Test
	public void eliminarDepartamentoTest() {
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.eliminarDepartamento("CD004");
	}
	
	/**
	 * Con este metodo testeamos el listado de un departamento de la base de datos.
	 */
	
	/*@Test
	public void listadoDepartamentosTest() {
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.listadoDepartamentos("CD001");

	}
	
	/**
	 * Con este metodo testeamos el listado por filtro de un departamento de la base de datos.
	 */
	
	/*@Test
	public void listarDepartamentosPorFitroTest() {
		String filtro = "CD003";
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.listadoDepartamentos(filtro);

	}
	
	/**
	 * Con este metodo testeamos la busqueda de un departamento en la base de datos.
	 */
	
	/*@Test
	public void buscarDepartamentoTest() {
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		assertNotNull(departamento.buscarDepartamento("CD001"));
	}*/
}
