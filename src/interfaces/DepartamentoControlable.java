package interfaces;

import java.util.ArrayList;

import clases.Departamento;

public interface DepartamentoControlable {
	
	public void añadirDepartamentos(Departamento departamento);
	
	public boolean modificarDepartamentos(Departamento departamento);
	
	public boolean eliminarDepartamentos(Departamento departamento);
	
	public ArrayList<Departamento> listadoDepartamentos();
	
	public Departamento buscarDepartamento(String codigoDepartamento);
}
