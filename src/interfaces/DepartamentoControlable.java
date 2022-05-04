package interfaces;

import java.util.ArrayList;

import clases.Departamento;

public interface DepartamentoControlable {
	
	public void añadirDepartamento(Departamento departamento);
	
	public boolean modificarDepartamento(Departamento departamento, String codDepartamento);
	
	public boolean eliminarDepartamento(String codDepartamento);
	
	public ArrayList<Departamento> listadoDepartamentos(String codDepartamento);
	
	public Departamento buscarDepartamento(String codigoDepartamento);
}
