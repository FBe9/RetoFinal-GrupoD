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
import interfaces.EmpleadoPacineteControlableBDImplementation;

public class EmpleadoPacineteControlableBDImplementationTest {

	private Connection con;
	private PreparedStatement stmt;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		
	}
	
	@Test
	public void openConnectionTest() {
		try {
			String url = "jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}	
	}

	@Test
	public void PacientesTest() {
		String wCic = null;
		
		EmpleadoPacineteControlableBDImplementation emple = new EmpleadoPacineteControlableBDImplementation();
		Paciente pac = new Paciente();
		pac.setCic("CP007");
		
		emple.añadirPaciente(pac);
		
		emple.buscarPaciente(wCic);
		
		assertEquals(emple, pac);
		
	}
	
	
}
