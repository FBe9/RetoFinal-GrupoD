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
	//Busca un objeto de tipo empleado y te lo devuelve
	public Empleado buscarEmpleado(String codEmple, Contrato contrato, Doctor doctor, Enfermero enfermero);
	
	//Añade un Empleado nuevo a la base de datos
	public void altaEmpleado(Empleado emple, Contrato contrato, Doctor doctor, Enfermero enfermero);
	
	//
	public ArrayList <Empleado> listarEmpleado();
	
	//Modifica un Empleado existente de la base de datos
	public boolean modificarEmpleado(Empleado emple, Contrato contrato, Doctor doctor, Enfermero enfermero);
	
	//Elimina un Empleado de la base de datos
	public void eliminarEmpleado(Empleado emple, Contrato contrato, Doctor doctor, Enfermero enfermero);
	
}
