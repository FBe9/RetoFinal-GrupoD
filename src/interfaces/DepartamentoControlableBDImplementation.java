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

	private Connection conexion;
	private PreparedStatement psttm;

	// QUERYS PARA MYSQL

	final String añadirDepartamentos = "INSERT INTO DEPART VALUES (?,?,?,?,?,?,?,?);";

	final String modificarDepartamentos = "UPDATE DEPART SET NAMEDEPART = ?, ACTIVDEPART = ?, SPECIALITY1 = ?, SPECIALITY2 = ?, SPECIALITY3 = ?, SPECIALITY4 = ?, SPECIALITY5 = ? WHERE CODDEPART = ?;";

	final String eliminarDepartamentos = "DELETE FROM DEPART WHERE CODDEPART = ?;";

	final String buscarDepartamento = "SELECT * FROM DEPART WHERE CODDEPART = ?;";

	final String listadoDepartamentos = "SELECT CODDEPART, NAMEDEPART FROM DEPART;";

	// CONEXIONES A MYSQL

	private void openConnection() {
		try {
			// String url = "jdbc:mysql://localhost/nombreBaseDatos";
			String url = "jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";
			// con = DriverManager.getConnection(url+"?" +"user=____&password=_____");
			conexion = DriverManager.getConnection(url, "root", "abcd*1234");
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	private void closeConnection() throws SQLException {
		if (psttm != null) {
			psttm.close();
		}
		if (conexion != null) {
			conexion.close();
		}
	}

	/**
	 * Añadir un Departamento a la base de datos
	 */

	@Override
	public void añadirDepartamentos(Departamento departamento) {

		try {

			String[] especialidades = departamento.getEspecialidades();

			openConnection();

			psttm = conexion.prepareStatement(añadirDepartamentos);

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

				closeConnection();

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * Se modifica un departamento en la base de datos
	 */

	@Override
	public boolean modificarDepartamentos(Departamento departamento, String codDepartamento) {

		boolean modificado = false;

		try {

			String[] especialidades = departamento.getEspecialidades();

			openConnection();

			psttm = conexion.prepareStatement(modificarDepartamentos);

			psttm.setString(1, departamento.getNombreDepartamento());

			psttm.setBoolean(2, departamento.getActivoDepartamento());

			psttm.setString(3, especialidades[0]);

			psttm.setString(4, especialidades[1]);

			psttm.setString(5, especialidades[2]);

			psttm.setString(6, especialidades[3]);

			psttm.setString(7, especialidades[4]);

			psttm.setString(8, codDepartamento);

			psttm.executeUpdate();

			if (psttm.executeUpdate() > 0) {
				modificado = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {

				closeConnection();

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return modificado;
	}

	@Override
	public boolean eliminarDepartamentos(Departamento departamento, String codDepartamento) {

		boolean eliminado = false;

		try {

			openConnection();

			psttm = conexion.prepareStatement(eliminarDepartamentos);

			psttm.setString(1, codDepartamento);

			psttm.executeUpdate();

			if (psttm.executeUpdate() > 0) {
				eliminado = true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} finally {
			try {

				closeConnection();

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return eliminado;
	}

	@Override
	public ArrayList<Departamento> listadoDepartamentos() {
		ResultSet rs = null;
		Departamento departamento = null;

		ArrayList<Departamento> departamentos = new ArrayList<>();

		openConnection();

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

				closeConnection();

			} catch (SQLException e) {

			}
		}

		
		return departamentos;
	}

	@Override
	public Departamento buscarDepartamento(String codigoDepartamento) {
		ResultSet rs = null;
		Departamento departamento = null;

		try {

			openConnection();

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

				closeConnection();

			} catch (SQLException e) {
				// TODO: handle exception
			}
		}

		return departamento;
	}

}
