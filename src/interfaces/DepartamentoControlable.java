package interfaces;

import java.util.ArrayList;

import clases.Departamento;

public interface DepartamentoControlable {
	
	public void aņadirDepartamentos(Departamento departamento);
	
	public boolean modificarDepartamentos(Departamento departamento, String codDepartamento);
	
	public boolean eliminarDepartamentos(Departamento departamento, String codDepartamento);
	
	public ArrayList<Departamento> listadoDepartamentos();
	
	public Departamento buscarDepartamento(String codigoDepartamento);
}
