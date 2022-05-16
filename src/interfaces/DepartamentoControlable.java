package interfaces;

import java.util.ArrayList;

import javax.swing.JTable;

import clases.Departamento;

public interface DepartamentoControlable {
	
	public void anadirDepartamento(Departamento departamento);
	
	public boolean modificarDepartamento(Departamento departamento);
	
	public boolean eliminarDepartamento(Departamento departamento);
	
	public ArrayList<Departamento> listadoDepartamentos();
	
	public Departamento buscarDepartamento(String codigoDepartamento);
}
