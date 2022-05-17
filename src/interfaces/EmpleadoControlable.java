package interfaces;

import java.util.ArrayList;
import java.util.Set;
import clases.*;
import exceptions.CreateSqlException;
/**
 * 
 * @author Nerea
 *
 */
public interface EmpleadoControlable {
	//Busca un objeto de tipo Empleado y te lo devuelve
	public Empleado buscarEmpleado(String codEmple, String nomDepart) throws CreateSqlException;
	
	//Busca un objeto de tipo Contrato y te lo devuelve
	public Contrato buscarContrato(String auxCodEmpleado, String auxCodContrato) throws CreateSqlException;
	
	//Aniade un Empleado nuevo a la base de datos
	public void altaEmpleado(Empleado emple, Contrato contrato) throws CreateSqlException;
	
	//Listar empleados en tabla
	public ArrayList <Empleado> listarEmpleado() throws CreateSqlException;
	
	//Cambia valores de un Empleado previamente registrado en la base de datos
	public boolean modificarEmpleado(Empleado emple, Contrato contrato) throws CreateSqlException;
	
	//Elimina un Empleado existente de la base de datos (Borrado logico)
	public boolean eliminarEmpleado(Empleado emple, String auxCodEmpleado) throws CreateSqlException;

	//Busca los tipos de los contratos
	ArrayList<String> buscarTipoContrato() throws CreateSqlException;

	//Busca los codigos de los departamentos
	ArrayList<String> buscarCodDepartamentos() throws CreateSqlException;
	
	//Busca horarios de los enfermeros
	ArrayList<String> buscarHorarios() throws CreateSqlException;

	//Buscar especialidades de un departamento
	ArrayList<String> buscarEspecialidades(String Departamento) throws CreateSqlException;
	
	public Empleado loginUsuario(String codigoDelUsuario, String contrasenaDelUsuario) throws CreateSqlException;
	
}