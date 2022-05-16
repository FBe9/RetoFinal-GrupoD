package jUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

	/*
	 * @Test public void openConnectionTest() { try { String url =
	 * "jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";
	 * con = DriverManager.getConnection(url, "root", "abcd*1234"); } catch
	 * (SQLException e) { System.out.println("Error al intentar abrir la BD"); }
	 * 
	 * }
	 */

	/*
	 * Probar insercion y busqueda de pacientes
	 */

	@Test
	public void PacientesTest() {
		EmpleadoPacineteControlableBDImplementation emple = new EmpleadoPacineteControlableBDImplementation();
		assertNotNull(emple.buscarPaciente("CE001"));

	}

	/*
	 * Funciona listarPacientesTest
	 */

	/*
	 * @Test public void listarPacientesTest() {
	 * EmpleadoPacineteControlableBDImplementation emple = new
	 * EmpleadoPacineteControlableBDImplementation();
	 * emple.listarPacientes("CE005");
	 * 
	 * }
	 */

	@Test
	public void añadirPacientesTest() {
		Paciente pac = new Paciente("CP005", "CE002", "CE006", "X", "A", "B", "C", "65489732", "Enfermedad", false);
		EmpleadoPacineteControlableBDImplementation emple = new EmpleadoPacineteControlableBDImplementation();
		emple.aniadirPaciente(pac);

	}

	/*
	 * @Test public void eliminarPacientesTest() {
	 * EmpleadoPacineteControlableBDImplementation emple = new
	 * EmpleadoPacineteControlableBDImplementation();
	 * emple.eliminarPaciente("CP009"); }
	 * 
	 * 
	 * @Test public void modificarPacientesTest() { Paciente pac = new
	 * Paciente("CP010", "CE001", "CE005", "12345678B", "nombre", "Apellidos",
	 * "65489732", "Enfermedad", true); EmpleadoPacineteControlableBDImplementation
	 * emple = new EmpleadoPacineteControlableBDImplementation();
	 * emple.modificarPaciente(pac, "CP010");
	 * 
	 * }
	 * 
	 */
	/*
	 * Funciona buscarPacientesFiltro
	 */


}

