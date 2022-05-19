package interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Departamento;
import exceptions.CreateSqlException;

/**
 * Clase que implementa los metodos de la interfaz DepartamentoControlable contra una BD.
 * @author Julen
 *
 */

public class DepartamentoControlableBDImplementation implements DepartamentoControlable {
	DBconnection db = new DBconnection();
	private Connection conexion;
	private PreparedStatement psttm;

	/**
	 * QUERYS PARA MYSQL
	 */

	final String anadirDepartamentos = "INSERT INTO DEPART VALUES (?,?,?,?,?,?,?,?);";

	final String modificarDepartamento = "UPDATE DEPART SET NAMEDEPART = ?, ACTIVDEPART = ? WHERE CODDEPART = ?;";

	final String eliminarDepartamento = "UPDATE DEPART SET ACTIVDEPART = ? WHERE CODDEPART = ?;";

	final String buscarDepartamento = "SELECT * FROM DEPART WHERE CODDEPART = ?;";

	final String listadoDepartamentos = "SELECT CODDEPART, NAMEDEPART FROM DEPART WHERE CODDEPART LIKE 'CD00%' ORDER BY CODDEPART ASC;";
	
	final String actualizarDepartamentos = "UPDATE DEPART SET NAMEDEPART = ?, ACTIVDEPART = ?, SPECIALTY1 = ?, SPECIALTY2 = ?, SPECIALTY3 = ?, SPECIALTY4 = ?, SPECIALTY5 = ? WHERE CODDEPART = ?;";

	/**
	 * Añadir un Departamento a la base de datos.
	 * @throws Exception: En caso de excepción se le mostrar al usuario un error. 
	 */

	@Override
	public boolean anadirDepartamento(Departamento departamento) throws CreateSqlException {
		boolean anadido = false;
		int auxAnadido = 0;
		
		try {
			
			conexion = db.openConnection();

			psttm = conexion.prepareStatement(anadirDepartamentos);
			
			String[] especialidades = departamento.getEspecialidades();

			psttm.setString(1, departamento.getCodDepartamento());
			psttm.setString(2, departamento.getNombreDepartamento());
			if(departamento.getActivoDepartamento() == false) {
				psttm.setBoolean(3,true);
			}
			psttm.setString(4, especialidades[0]);
			psttm.setString(5, especialidades[1]);
			psttm.setString(6, especialidades[2]);
			psttm.setString(7, especialidades[3]);
			psttm.setString(8, especialidades[4]);

			auxAnadido = psttm.executeUpdate();
			
			if(auxAnadido == 1) {
				anadido = true;
			}
		} catch (SQLException e) {
			String error = ("Error en la introducción de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}
		return anadido;
	}

	/**
	 * Se modifica un departamento en la base de datos
	 * @throws Exception: En caso de excepción se le mostrar al usuario un error. 
	 */

	@Override
	public boolean modificarDepartamento(Departamento departamento) throws CreateSqlException {
		
		int auxModificado;
		boolean modificado = false;

		try {

			conexion = db.openConnection();

			psttm = conexion.prepareStatement(modificarDepartamento);

			psttm.setString(1, departamento.getNombreDepartamento());

			psttm.setBoolean(2, departamento.getActivoDepartamento());
			
			psttm.setString(3, departamento.getCodDepartamento());

			auxModificado =  psttm.executeUpdate();
			
			if(auxModificado == 1) {
				modificado = true;
			}

		} catch (SQLException e) {
			String error = ("Error en la modificación de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return modificado;
	}
	
	/**
	 * Se elimina un departamento de la base de datos
	 * @throws Exception: En caso de excepción se le mostrar al usuario un error. 
	 */

	@Override
	public boolean eliminarDepartamento(Departamento departamento) throws CreateSqlException {

		boolean eliminado = false;
		

		try {

			conexion = db.openConnection();

			psttm = conexion.prepareStatement(eliminarDepartamento);

			psttm.setString(2, departamento.getCodDepartamento());
			
			if(departamento.getActivoDepartamento() != false) {
				psttm.setBoolean(1,false);
			}
			

			psttm.executeUpdate();

			if (psttm.executeUpdate() > 0) {
				eliminado = true;
			}
		} catch (SQLException e) {
			String error = ("Error en la eliminación de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return eliminado;
	}
	
	/**
	 * Se listan todos los departamentos introducidos en la base de datos
	 * @throws Exception: En caso de excepción se le mostrar al usuario un error.  
	 */

	@Override
	public ArrayList<Departamento> listadoDepartamentos() throws CreateSqlException {
		ResultSet rs = null;
		Departamento departamento = null;

		ArrayList<Departamento> departamentos = new ArrayList<>();

		conexion = db.openConnection();

		try {
			psttm = conexion.prepareStatement(listadoDepartamentos);

			rs = psttm.executeQuery();

			while (rs.next()) {
				departamento = new Departamento();
				departamento.setCodDepartamento(rs.getString(1));
				departamento.setNombreDepartamento(rs.getString(2));
				departamentos.add(departamento);

			}
		} catch (SQLException e) {
			String error =("Error en listar los datos de la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		
		return departamentos;
	}
	
	
	/**
	 * Se busca un departamento en concreto en la base de datos
	 * @throws Exception: En caso de excepción se le mostrar al usuario un error. 
	 */

	@Override
	public Departamento buscarDepartamento(String codigoDepartamento) throws CreateSqlException {
		ResultSet rs = null;
		Departamento departamento = null;

		try {

			conexion = db.openConnection();

			psttm = conexion.prepareStatement(buscarDepartamento);
			psttm.setString(1, codigoDepartamento);

			rs = psttm.executeQuery();

			if (rs.next()) {

				departamento = new Departamento();
				departamento.setCodDepartamento(rs.getString(1));
				departamento.setNombreDepartamento(rs.getString(2));
				departamento.setActivoDepartamento(rs.getBoolean(3));

				String[] especialidades = departamento.getEspecialidades();

				especialidades[0] = rs.getString(4);
				especialidades[1] = rs.getString(5);
				especialidades[2] = rs.getString(6);
				especialidades[3] = rs.getString(7);
				especialidades[4] = rs.getString(8);

			} else
				departamento = null;
		} catch (SQLException e) {
			String error =("Error en la busqueda de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return departamento;
	}
}
