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
	
	//
	public ArrayList <Empleado> listarEmpleado();
	
	//Cambia valores de un Empleado previamente registrado en la base de datos
	public boolean modificarEmpleado(Empleado emple, Contrato contrato);
	
	//Elimina un Empleado existente de la base de datos
	public void eliminarEmpleado(Empleado emple, Contrato contrato);
	
}
