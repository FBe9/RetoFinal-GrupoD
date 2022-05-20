package jUnit;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Departamento;
import exceptions.CreateSqlException;
import interfaces.DepartamentoControlableBDImplementation;

/**
 * Clase en el que se testean todos los metodos que se implementan de la interfaz DepartamentoControlable.
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

	@Test
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
	 * @throws CreateSqlException 
	 */
	
	@Test 
	public void añadirDepartamentoTest() throws CreateSqlException { 
		
		String[] especialidades = new String[] {"a","a","a","a","a"};
		
		Departamento depart = new Departamento("CD004", "a", true, especialidades);
		  
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.anadirDepartamento(depart);
		assertNotNull(departamento.buscarDepartamento("CD004"));
		  
	}
	
	/**
	 * Con este metodo testeamos la modificacion de un departamento en la base de datos.
	 * @throws CreateSqlException 
	 */
	
	@Test
	public void modificarDepartamentoTest() throws CreateSqlException {
		
		String[] especialidades = new String[] {"b","b","b","b","b"};
		
		Departamento depart = new Departamento("CD004", "a", true, especialidades);
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.modificarDepartamento(depart);
		assertNotNull(departamento.buscarDepartamento("CD004"));

	}
	
	/**
	 * Con este metodo testeamos la eliminacion de un departamento en la base de datos.
	 * @throws CreateSqlException 
	 */
	
	@Test
	public void eliminarDepartamentoTest() throws CreateSqlException {
		String[] especialidades = new String[] {"b","b","b","b","b"};
		
		Departamento depart = new Departamento("CD004", "a", true, especialidades);
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		departamento.eliminarDepartamento(depart);
		assertNull(departamento.buscarDepartamento("CD004"));
	}
	
	/**
	 * Con este metodo testeamos el listado de un departamento de la base de datos.
	 * @throws CreateSqlException 
	 */
	
	@Test
	public void listadoDepartamentosTest() throws CreateSqlException {
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		assertNull(departamento.listadoDepartamentos());

	}
	
	/**
	 * Con este metodo testeamos la busqueda de un departamento en la base de datos.
	 */
	
	@Test
	public void buscarDepartamentoTest() throws CreateSqlException {
		DepartamentoControlableBDImplementation departamento = new DepartamentoControlableBDImplementation();
		assertNotNull(departamento.buscarDepartamento("CD004"));
	}
}
