package jUnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Paciente;
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
		emple.buscarPaciente("CP001");

	}

	@Test
	public void listarPacientesTest() {
		EmpleadoPacineteControlableBDImplementation emple = new EmpleadoPacineteControlableBDImplementation();
		emple.listarPacientes();

	}

	/*
	 * 
	 * @Test public void añadirPacientesTest() { Paciente pac = new
	 * Paciente("CP010", "CE002", "CE006", "A", "B", "C", "65489732", "Enfermedad",
	 * false);
	 * 
	 * EmpleadoPacineteControlableBDImplementation emple = new
	 * EmpleadoPacineteControlableBDImplementation(); emple.añadirPaciente(pac);
	 * emple.buscarPaciente(pac.getCic());
	 * 
	 * }
	 * 
	 */
	
	@Test
	public void eliminarPacientesTest() {
		EmpleadoPacineteControlableBDImplementation emple = new EmpleadoPacineteControlableBDImplementation();
		emple.eliminarPaciente("CP009");

	}

}
