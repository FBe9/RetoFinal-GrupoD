package interfaces;

import java.util.ArrayList;
import java.util.Set;
import clases.*;
/**
 * 
 * @author Nerea
 *
 */
public interface EmpleadoControlable {
	//Busca un objeto de tipo Empleado y te lo devuelve
	public Empleado buscarEmpleado(String codEmple, String nomDepart);
	
	//Busca un objeto de tipo Contrato y te lo devuelve
	public Contrato buscarContrato(String auxCodEmpleado, String auxCodContrato);
	
	//Añade un Empleado nuevo a la base de datos
	public void altaEmpleado(Empleado emple, Contrato contrato);
	
	//Listar empleados en tabla
	public ArrayList <Empleado> listarEmpleado();
	
	//Cambia valores de un Empleado previamente registrado en la base de datos
	public boolean modificarEmpleado(Empleado emple, Contrato contrato);
	
	//Elimina un Empleado existente de la base de datos (Borrado logico)
	public boolean eliminarEmpleado(Empleado emple, String auxCodEmpleado);

	//Busca los tipos de los contratos
	ArrayList<String> buscarTipoContrato();

	//Busca los codigos de los departamentos
	ArrayList<String> buscarCodDepartamentos();
	
	//Busca horarios de los enfermeros
	ArrayList<String> buscarHorarios();

	//Buscar especialidades de un departamento
	ArrayList<String> buscarEspecialidades(String Departamento);
	
	public Empleado loginUsuario(String codigoDelUsuario, String contrasenaDelUsuario);
	
}