package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import clases.Departamento;

public class DepartamentoControlableBDImplementation implements DepartamentoControlable {
	DBconnection db = new DBconnection();
	private Connection conexion;
	private PreparedStatement psttm;

	// QUERYS PARA MYSQL

	final String aņadirDepartamentos = "INSERT INTO DEPART VALUES (?,?,?,?,?,?,?,?);";

	final String modificarDepartamento = "UPDATE DEPART SET NAMEDEPART = ?, ACTIVDEPART = ? WHERE CODDEPART = ?;";

	final String eliminarDepartamento = "UPDATE DEPART SET ACTIVDEPART = ? WHERE CODDEPART = ?;";

	final String buscarDepartamento = "SELECT * FROM DEPART WHERE CODDEPART = ?;";

	final String listadoDepartamentos = "SELECT CODDEPART, NAMEDEPART FROM DEPART;";
	
	final String listarDepartamentosPorFitro = "SELECT CODDEPART, NAMEDEPART FROM DEPART WHERE CODDEPART=? OR NAMEDEPART=?";

	/**
	 * Aņadir un Departamento a la base de datos
	 */

	@Override
	public void anadirDepartamento(Departamento departamento) {

		try {

			String[] especialidades = departamento.getEspecialidades();

			conexion = db.openConnection();

			psttm = conexion.prepareStatement(aņadirDepartamentos);

			psttm.setString(1, departamento.getCodDepartamento());
			psttm.setString(2, departamento.getNombreDepartamento());
			psttm.setBoolean(3, departamento.getActivoDepartamento());
			psttm.setString(4, especialidades[0]);
			psttm.setString(5, especialidades[1]);
			psttm.setString(6, especialidades[2]);
			psttm.setString(7, especialidades[3]);
			psttm.setString(8, especialidades[4]);

			psttm.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				//GestorException ex=new GestorException("Error ");
				//throw ex;
			}
		}
	}

	/**
	 * Se modifica un departamento en la base de datos
	 */

	@Override
	public boolean modificarDepartamento(Departamento departamento) {
		
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
			// TODO: handle exception
		} finally {
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return modificado;
	}
	
	/**
	 * Se elimina un departamento de la base de datos
	 */

	@Override
	public boolean eliminarDepartamento(Departamento departamento) {

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
			// TODO: handle exception
		} finally {
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return eliminado;
	}
	
	/**
	 * Se listan todos los departamentos introducidos en la base de datos
	 */

	@Override
	public ArrayList<Departamento> listadoDepartamentos() {
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

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {

			}
		}

		
		return departamentos;
	}
	
	/**
	 * Se listan todos los departamentos por filtro introducidos en la base de datos
	 */
	
	@Override
	public ArrayList<Departamento> listadoDepartamentosPorFiltro(String filtro) {
		ResultSet rs = null;
		Departamento departamento = null;

		ArrayList<Departamento> departamentos = new ArrayList<>();

		conexion = db.openConnection();

		try {
			psttm = conexion.prepareStatement(listarDepartamentosPorFitro);

			psttm.setString(1, filtro);
			psttm.setString(2, filtro);
			
			rs = psttm.executeQuery();

			while (rs.next()) {
				departamento = new Departamento();
				departamento.setCodDepartamento(rs.getString(1));
				departamento.setNombreDepartamento(rs.getString(2));

				departamentos.add(departamento);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {

				}
			}
			try {
				db.closeConnection(psttm, conexion);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return departamentos;
	}
	
	/**
	 * Se busca un departamento en concreto en la base de datos
	 */

	@Override
	public Departamento buscarDepartamento(String codigoDepartamento) {
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
			// TODO: handle exception
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

				}
			}
			try {

				db.closeConnection(psttm, conexion);

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return departamento;
	}

}
