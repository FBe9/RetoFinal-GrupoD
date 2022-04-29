package interfaces;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clases.Paciente;

public class EmpleadoPacineteControlableBDImplementation implements EmpleadosPacienteControlable {
	DBconnection db = new DBconnection();
	private Connection con;
	private PreparedStatement stmt;

	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");
			
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	// Query para MySQL

	final String altaPaciente = "INSERT INTO PATIENT VALUES(?,?,?,?,?,?,?,?,?,?)";

	final String bajaPaciente = "DELETE FROM PATIENT WHERE cic=?";
	final String modificarPaciente = "UPDATE PATIENT SET codEmployeeDoctor=?, codEmployeeNurse=?, dniPatient=?, namePatient=?, lastNamePatient1=?, lastNamePatient2=?, tlf=?, disease=?, recoverPatient=?"
			+ " WHERE cic=?";
	final String listarPaciente = "SELECT * FROM PATIENT WHERE cic=?";
	
	final String listarPacientesTabla = "SELECT cic, namePatient, disease FROM PATIENT";
	
	final String listarPacienteTablaFitroCic = "SELECT cic, namePatient, disease FROM PATIENT WHERE cic=?";
	final String listarPacienteTablaFitroNamePatient = "SELECT cic, namePatient, disease FROM PATIENT WHERE namePatient=?";
	final String listarPacienteTablaFitroDisease = "SELECT cic, namePatient, disease FROM PATIENT WHERE disease=?";
	

	/*
	 * busqueda de pacientes
	 */

	@Override
	public Paciente buscarPaciente(String wCic) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Paciente pac = null;

		try {
			openConnection();
			stmt = con.prepareStatement(listarPaciente);
			stmt.setString(1, wCic);

			rs = stmt.executeQuery();

			if (rs.next()) {
				pac = new Paciente();
				pac.setCic(rs.getString(1));
				pac.setCodEmpleadoDoctor(rs.getString(2));
				pac.setCodEmpleadoEnfermero(rs.getString(3));
				pac.setDniPaciente(rs.getString(4));
				pac.setNombrePaciente(rs.getString(5));
				pac.setApellidosPaciente(rs.getString(6));
				pac.setApellidosPaciente(rs.getString(7));
				pac.setTlf(rs.getString(8));
				pac.setEnfermedad(rs.getString(9));
				pac.setPacienteRecuperado(rs.getBoolean(10));
			} else
				pac = null;
		} catch (SQLException e) {
			System.out.println("Error del new Paciente " + e.getMessage());
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
				System.out.println("Error despues del finally" + e.getMessage());
			}
		}

		return pac;

	}

	/*
	 * Crea y a�ade un paciente
	 */
	@Override
	public void a�adirPaciente(Paciente pac) {
		
		try {
			openConnection();
			
			stmt = con.prepareStatement(altaPaciente);

			stmt.setString(1, pac.getCic());
			stmt.setString(2, pac.getCodEmpleadoDoctor());
			stmt.setString(3, pac.getCodEmpleadoEnfermero());
			stmt.setString(4, pac.getDniPaciente());
			stmt.setString(5, pac.getNombrePaciente());
			stmt.setString(6, pac.getApellidosPaciente());
			stmt.setString(7, pac.getApellidosPaciente());
			stmt.setString(8, pac.getTlf());
			stmt.setString(9, pac.getEnfermedad());
			stmt.setBoolean(10, pac.isPacienteRecuperado());

			stmt.executeUpdate();
		} catch (SQLException e1) {
			//
			// e1.printStackTrace();
			// CreateException ex=new CreateException(e1.getMessage());
			e1.printStackTrace();

			// throw new CreateException(e1.getMessage());
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}	
	
	/*
	 * Lista los pacientes en base a su CIC con su nombre y su enfermedad
	 * correspondiente
	 */
	@Override
	public ArrayList<Paciente> listarPacientes() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Paciente pac = null;

		ArrayList<Paciente> pacientes = new ArrayList<>();

		openConnection();

		try {
			stmt = con.prepareStatement(listarPacientesTabla);

			rs = stmt.executeQuery();

			while (rs.next()) {
				pac = new Paciente();
				pac.setCic(rs.getString(1));
				pac.setNombrePaciente(rs.getString(2));
				pac.setEnfermedad(rs.getString(3));
				pacientes.add(pac);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
			}
		}

		return pacientes;

	}

	@Override
	public boolean modificarPaciente(Paciente pac) {
		// TODO Auto-generated method stub

		boolean modificado = false;

		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(modificarPaciente);

			stmt.setString(1, pac.getCodEmpleadoDoctor());
			stmt.setString(2, pac.getCodEmpleadoEnfermero());
			stmt.setString(3, pac.getNombrePaciente());
			stmt.setString(4, pac.getApellidosPaciente());
			stmt.setString(5, pac.getApellidosPaciente());
			stmt.setString(6, pac.getTlf());
			stmt.setString(7, pac.getEnfermedad());
			stmt.setBoolean(8, pac.isPacienteRecuperado());

			stmt.executeUpdate();
			if (stmt.executeUpdate() > 0) {
				modificado = true;
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return modificado;
	}

	@Override
	public boolean eliminarPaciente(Paciente pac) {
		// TODO Auto-generated method stub
		boolean modified = false;

		openConnection();

		try {
			stmt = con.prepareStatement(bajaPaciente);

			stmt.setString(1, pac.getCic());

			stmt.executeUpdate();

			if (stmt.executeUpdate() > 0) {
				modified = true;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return modified;
	}
	
	@Override
	public ArrayList<Paciente> listarPacientesFiltro(String filtro) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Paciente pac = null;

		ArrayList<Paciente> pacientes = new ArrayList<>();

		openConnection();

		try {
			stmt = con.prepareStatement(listarPacienteTablaFitroCic);

			rs = stmt.executeQuery();

			while (rs.next()) {
				pac = new Paciente();
				stmt.setString(1, pac.getCic());
				stmt.setString(2, pac.getNombrePaciente());
				stmt.setString(3, pac.getEnfermedad());
				pacientes.add(pac);
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
				closeConnection();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return pacientes;
	}

}