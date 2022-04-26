package interfaces;

import java.util.ArrayList;
import java.util.Set;
import clases.*;

public interface EmpleadoControlable {
	//Busca un objeto de tipo empleado y te lo devuelve
	public Empleado buscarEmpleado(String codEmpleado);
	
	//Añade un Empleado nuevo a la base de datos
	public void altaEmpleado(Empleado auxEmple);
	
	//
	public ArrayList <Empleado> listarEmpleado();
	
	//Modifica un Empleado existente de la base de datos
	public boolean modificarEmpleado();
	
	//Elimina un Empleado de la base de datos
	public void eliminarEmpleado();
	
}
