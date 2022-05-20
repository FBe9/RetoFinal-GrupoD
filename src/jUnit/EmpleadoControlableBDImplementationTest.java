package jUnit;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;

import clases.Contrato;
import clases.Empleado;
import exceptions.CreateSqlException;
import interfaces.EmpleadoControlableBDImplementation;

/**
 * Clase en el que se testean todos los metodos que se implementan de la interfaz EmpleadoControlable.
 * @author Nerea
 *
 */
public class EmpleadoControlableBDImplementationTest {
	EmpleadoControlableBDImplementation emple;

	@Test
	public void testBuscarEmpleado() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarEmpleado("CE001"));
	}

	@Test
	public void testBuscarContrato() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarContrato("CE001"));
	}

	@Test
	public void testBuscarEspecialidadHorario() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarEspecialidadHorario("CE001"));
	}

	@Test
	public void testBuscarTipoContrato()throws CreateSqlException {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarTipoContrato());
	}

	@Test
	public void testBuscarCodDepartamentos()throws CreateSqlException {
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarCodDepartamentos());
	}

	@Test
	public void testBuscarEspecialidades() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarEspecialidades("CD003"));
	}

	@Test
	public void testBuscarHorarios() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.buscarHorarios());
	}

	
	@Test
	public void testAltaEmpleado() throws CreateSqlException{
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
	public void testListarEmpleadosTabla() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.listarEmpleadosTabla());
	}

	
	@Test
	public void testModificarEmpleado() throws CreateSqlException{
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
	public void testEliminarEmpleado() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		Empleado empleado = new Empleado("CE007", "CD002", "78649023G", "Steven IV",
				"Velazquez", null, true, "Doctor",
				"abcd*1234");
		
		assertNotNull(emple.eliminarEmpleado(empleado, "CE007"));
	}
	
	@Test
	public void loginUsuario() throws CreateSqlException{
		emple = new EmpleadoControlableBDImplementation();
		assertNotNull(emple.loginUsuario("Admin", "abcd*1234"));
	}
}
