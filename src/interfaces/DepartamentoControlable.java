package interfaces;

import java.util.ArrayList;

import javax.swing.JTable;

import clases.Departamento;
import exceptions.CreateSqlException;

public interface DepartamentoControlable {
	
	public boolean anadirDepartamento(Departamento departamento) throws CreateSqlException;
	
	public boolean modificarDepartamento(Departamento departamento) throws CreateSqlException;
	
	public boolean eliminarDepartamento(Departamento departamento) throws CreateSqlException;
	
	public ArrayList<Departamento> listadoDepartamentos() throws CreateSqlException;
	
	public Departamento buscarDepartamento(String codigoDepartamento) throws CreateSqlException;
}
