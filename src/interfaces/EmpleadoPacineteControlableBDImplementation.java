package interfaces;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clases.Paciente;

public class EmpleadoPacineteControlableBDImplementation implements EmpleadosPacienteControlable {

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

	final String altaPaciente = "INSERT INTO PATIENT(cic, codEmployeeDoctor, codEmployeeNurse, dniPatient, namePatient, lastNamePatient1, lastNamePatient2, tlf, disease, recoverPatient) "
			+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

	final String bajaPaciente = "DELETE FROM PATIENT WHERE cic=?";
	final String modificarPaciente = "UPDATE PATIENT SET codEmployeeDoctor =?, codEmployeeNurse =?, dniPatient =?, namePatient =?, lastNamePatient1 =?, lastNamePatient2 =?, tlf =?, disease =?, recoverPatient =?"
			+ " WHERE cic=?";
	final String listarPaciente = "SELECT * FROM PATIENT";
	final String listarPacienteTabla = "SELECT * FROM PATIENT";

	
	@Override
	public Paciente buscarPaciente(String wCic) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Paciente pac = null;

		openConnection();

		try {
			stmt = con.prepareStatement(listarPaciente);

			stmt.setString(1, wCic);

			rs = stmt.executeQuery();

			if (rs.next()) {
				pac = new Paciente();
				pac.setCic(rs.getString(1));

			} else
				pac = null;
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

		return pac;

	}

	@Override
	public void añadirPaciente(Paciente pac) {
		// TODO Auto-generated method stub
		openConnection();

		try {
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

	@Override
	public ArrayList<Paciente> listarPacientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarPaciente(Paciente prop) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarPaciente(Paciente prop) {
		// TODO Auto-generated method stub

	}

}
