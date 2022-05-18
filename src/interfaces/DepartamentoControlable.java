package interfaces;

import java.util.ArrayList;

import clases.Departamento;
import exceptions.CreateSqlException;

/**
 * Interfaz en el que se declaran los metodos que tendran las clases que lo implementen.
 * @author Julen
 *
 */

public interface DepartamentoControlable {
	
	/**
	 * Declaración del metodo para dar de alta a un departamento.
	 * @param departamento: objeto con los datos del departamento.
	 * @return boolean: Confirmación si se ha realizado correctamente el alta.
	 * @throws CreateSqlException: Mensaje personalizado para cada excepcion SQL.
	 */
	
	public boolean anadirDepartamento(Departamento departamento) throws CreateSqlException;
	
	/**
	 * Declaración del metodo para modificar un departamento.
	 * @param departamento: objeto con los datos del departamento.
	 * @return boolean: Confirmación si se ha realizado correctamente la modificación.
	 * @throws CreateSqlException: Mensaje personalizado para cada excepcion SQL.
	 */
	
	public boolean modificarDepartamento(Departamento departamento) throws CreateSqlException;
	
	/**
	 * Declaración del metodo para dar de baja a un departamento.
	 * @param departamento: objeto con los datos del departamento.
	 * @return boolean: Confirmación si se ha realizado correctamente la baja.
	 * @throws CreateSqlException: Mensaje personalizado para cada excepcion SQL.
	 */
	
	public boolean eliminarDepartamento(Departamento departamento) throws CreateSqlException;
	
	/**
	 * Declaración del metodo para listar todos y cada una de los departamentos existentes.
	 * @return  ArrayList<Departamento>: ArrayList con todos los departamentos existentes. 
	 * @throws CreateSqlException: Mensaje personalizado para cada excepcion SQL.
	 */
	
	public ArrayList<Departamento> listadoDepartamentos() throws CreateSqlException;
	
	/**
	 * Declaración del metodo para buscar un departamento apartir de su codigo.
	 * @param codigoDepartamento: Codigo del departamento a buscar
	 * @return Departamento: Todos los datos del departamento buscado.
	 * @throws CreateSqlException: Mensaje personalizado para cada excepcion SQL.
	 */
	
	public Departamento buscarDepartamento(String codigoDepartamento) throws CreateSqlException;
}
