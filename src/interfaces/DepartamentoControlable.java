package interfaces;

import java.util.ArrayList;

import clases.Departamento;

public interface DepartamentoControlable {
	
	public void anadirDepartamento(Departamento departamento);
	
	public boolean modificarDepartamento(Departamento departamento);
	
	public boolean eliminarDepartamento(Departamento departamento);
	
	public ArrayList<Departamento> listadoDepartamentos();
	
	public ArrayList<Departamento> listadoDepartamentosPorFiltro(String filtro);
	
	public Departamento buscarDepartamento(String codigoDepartamento);
}
