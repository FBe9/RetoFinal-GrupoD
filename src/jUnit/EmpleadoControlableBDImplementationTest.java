package jUnit;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import clases.Contrato;
import clases.Empleado;
import interfaces.EmpleadoControlableBDImplementation;

public class EmpleadoControlableBDImplementationTest {
	EmpleadoControlableBDImplementation emple;

	@Test
	public void testBuscarEmpleado() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarEmpleado("CE001"));
	}

	@Test
	public void testBuscarContrato() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarContrato("CE001"));
	}

	@Test
	public void testBuscarEspecialidadHorario() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarEspecialidadHorario("CE001"));
	}

	@Test
	public void testBuscarTipoContrato() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarTipoContrato());
	}

	@Test
	public void testBuscarCodDepartamentos() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarCodDepartamentos());
	}

	@Test
	public void testBuscarEspecialidades() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarEspecialidades("CD003"));
	}

	@Test
	public void testBuscarHorarios() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarHorarios());
	}

	
	@Test
	public void testAltaEmpleado() {
		emple = new EmpleadoControlableBDImplementation();
		Empleado empleado = new Empleado("CE007", "CD002", "78649023G", "Steven IV",
				"Velazquez", null, false, "Doctor",
				"abcd*1234");
		
		Date date = Date.valueOf(LocalDate.now());
		Date date2 = Date.valueOf(LocalDate.now());
		
		Contrato contrato = new Contrato("CC007", "Fijo", date, date2);
		
		emple.altaEmpleado(empleado, contrato, "a");
		assertNotNull(emple.buscarEmpleado("CE007"));
	}

	@Test
	public void testListarEmpleadosTabla() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.listarEmpleadosTabla());
	}

	
	@Test
	public void testModificarEmpleado() {
		emple = new EmpleadoControlableBDImplementation();
		Empleado empleado = new Empleado("CE007", "CD002", "78649023G", "Steven IV",
				"Velazquez", null, true, "Doctor",
				"abcd*1234");
		
		Date date = Date.valueOf(LocalDate.now());
		Date date2 = Date.valueOf(LocalDate.now());
		
		Contrato contrato = new Contrato("CC007", "Fijo", date, date2);
		emple.modificarEmpleado(empleado, contrato, "a");
		
	}

	@Test
	public void testEliminarEmpleado() {
		emple = new EmpleadoControlableBDImplementation();
		Empleado empleado = new Empleado("CE007", "CD002", "78649023G", "Steven IV",
				"Velazquez", null, true, "Doctor",
				"abcd*1234");
		
		assertNotNull(emple.eliminarEmpleado(empleado, "CE007"));
	}
	
	@Test
	public void loginUsuario() {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.loginUsuario("Admin", "abcd*1234"));
	}
}
