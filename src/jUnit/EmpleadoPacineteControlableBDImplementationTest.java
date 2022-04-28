package jUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clases.Paciente;
import interfaces.DBconnection;
import interfaces.EmpleadoPacineteControlableBDImplementation;

public class EmpleadoPacineteControlableBDImplementationTest {

	Connection con;
	PreparedStatement stmt;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

	}

	/*
	 * Probar conexion a la base de datos
	 */
	@Test
	public void openConnectionTest() {
		try {
			String url = "jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	/*
	 * Probar insercion y busqueda de pacientes
	 */
	@Test
	public void PacientesTest() {
		
		EmpleadoPacineteControlableBDImplementation emple = new EmpleadoPacineteControlableBDImplementation();
		
	}
	
	@Test
	public void listarPacientesTest() {
		
		EmpleadoPacineteControlableBDImplementation emple = new EmpleadoPacineteControlableBDImplementation();
		
		emple.listarPacientes();
		
	}

}
