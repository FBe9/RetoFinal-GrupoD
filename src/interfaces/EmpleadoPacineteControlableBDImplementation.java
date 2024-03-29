package interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clases.Paciente;
import exceptions.CreateSqlException;

/**
 * Esta es la clase que implementa los pacientes en la base de datos
 * @author Emil
 *
 */

public class EmpleadoPacineteControlableBDImplementation implements EmpleadosPacienteControlable {
	DBconnection db = new DBconnection();
	private Connection con;
	private PreparedStatement stmt;
	private CreateSqlException ex;
	
	// Query para MySQL
	
	final String altaPaciente = "INSERT INTO PATIENT VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	final String bajaPaciente = "DELETE FROM PATIENT WHERE cic=?";
	
	final String modificarPaciente = "UPDATE PATIENT SET codEmployeeDoctor=?, codEmployeeNurse=?, dniPatient=?, namePatient=?, lastNamePatient1=?, lastNamePatient2=?, tlf=?, disease=?, recoverPatient=?"
			+ " WHERE cic=?";
	
	final String listarPaciente = "SELECT * FROM PATIENT WHERE cic=?";
	
	final String listarPacientesTabla = "SELECT cic, namePatient, disease FROM PATIENT WHERE (codEmployeeDoctor=? OR codEmployeeNurse=?)";
	
	final String listarCodigosMedicos = "SELECT codEmployee FROM doctor ";
	
	final String listarCodigosEnfermeros = "SELECT * FROM nurse ";
	

	/**
	 * Este recoge la query que busca un paciente en la base de datos
	 * @param wCic codigo del paciente
	 */
	@Override
	public Paciente buscarPaciente(String wCic){
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Paciente pac = null;

		con = db.openConnection();
		
		try {
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
				pac.setApellidoPaciente(rs.getString(6));
				pac.setApellido2Paciente(rs.getString(7));
				pac.setTlf(rs.getString(8));
				pac.setEnfermedad(rs.getString(9));
				pac.setPacienteRecuperado(rs.getBoolean(10));
			} else
				pac = null;
		} catch (SQLException e) {
			
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error despues del finally" + e.getMessage());
			}
		}

		return pac;

	}

	/*
	 * Crea y aniade un paciente
	 */
	@Override
	public void aniadirPaciente(Paciente pac) {

		try {
			con = db.openConnection();

			stmt = con.prepareStatement(altaPaciente);

			stmt.setString(1, pac.getCic());
			stmt.setString(2, pac.getCodEmpleadoDoctor());
			stmt.setString(3, pac.getCodEmpleadoEnfermero());
			stmt.setString(4, pac.getDniPaciente());
			stmt.setString(5, pac.getNombrePaciente());
			stmt.setString(6, pac.getApellidoPaciente());
			stmt.setString(7, pac.getApellido2Paciente());
			stmt.setString(8, pac.getTlf());
			stmt.setString(9, pac.getEnfermedad());
			stmt.setBoolean(10, pac.isPacienteRecuperado());

			stmt.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();

			// throw new CreateException(e1.getMessage());
		} finally {
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	
	/*
	 * Recoge la lista los pacientes en base a su CIC con su nombre y su enfermedad correspondiente
	 * @param codEmple el codigo del empleado 
	 */
	@Override
	public ArrayList<Paciente> listarPacientes(String codEmple) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Paciente pac = null;

		ArrayList<Paciente> pacientes = new ArrayList<>();

		con = db.openConnection();

		try {
			stmt = con.prepareStatement(listarPacientesTabla);

			stmt.setString(1, codEmple);
			stmt.setString(2, codEmple);

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
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return pacientes;

	}
	
	/**
	 * Recibe los datos del paciente y el codigo de este para modificar, y te devuelve un boolean si se ha hecho o no 
	 * 
	 * @param Paciente pac el paciente que vas a modificar
	 * @param wCic El codigo del paciente
	 */
	@Override
	public boolean modificarPaciente(Paciente pac, String wCIC) {
		// TODO Auto-generated method stub

		boolean modificado = false;

		con = db.openConnection();

		try {
			
			stmt = con.prepareStatement(modificarPaciente);

			stmt.setString(1, pac.getCodEmpleadoDoctor());
			stmt.setString(2, pac.getCodEmpleadoEnfermero());
			stmt.setString(3, pac.getDniPaciente());
			stmt.setString(4, pac.getNombrePaciente());
			stmt.setString(5, pac.getApellidoPaciente());
			stmt.setString(6, pac.getApellido2Paciente());
			stmt.setString(7, pac.getTlf());
			stmt.setString(8, pac.getEnfermedad());
			stmt.setBoolean(9, pac.isPacienteRecuperado());

			stmt.setString(10, wCIC);

			stmt.executeUpdate();
			if (stmt.executeUpdate() > 0) {
				modificado = true;
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return modificado;
	}
	
	/**
	 * Recibe el codigo del paciente, lo elimina de la base de datos y te devuelve un boolean en caso de hacerlo correctamente
	 * 
	 * @param wCic codigo del paciente
	 */
	@Override
	public boolean eliminarPaciente(String wCIC) {
		// TODO Auto-generated method stub
		boolean modified = false;

		con = db.openConnection();

		try {
			stmt = con.prepareStatement(bajaPaciente);

			stmt.setString(1, wCIC);

			stmt.executeUpdate();

			if (stmt.executeUpdate() > 0) {
				modified = true;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return modified;
	}
	
	/**
	 * Recoge los codigos de todos los medicos para listarlos en un combobox en el alta
	 * 
	 */
	@Override
	public ArrayList<String> listaMedicos() {
		ResultSet rs = null;
		
		ArrayList<String> listaCodigoMedico = new ArrayList<>();

		con = db.openConnection();

		try {
			stmt = con.prepareStatement(listarCodigosMedicos);

			rs = stmt.executeQuery();
			
			while (rs.next()) {
				listaCodigoMedico.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			if (rs != null) {

					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return listaCodigoMedico;

	}
	
	
	/**
	 * Listado de los codigos de los enfermeros
	 */
	@Override
	public ArrayList<String> listaEnfermeros() {
		ResultSet rs = null;
		
		ArrayList<String> listaCodigoEnfermero = new ArrayList<>();

		con = db.openConnection();

		try {
			stmt = con.prepareStatement(listarCodigosEnfermeros);

			rs = stmt.executeQuery();
			
			while (rs.next()) {
				listaCodigoEnfermero.add(rs.getString(1));
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
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return listaCodigoEnfermero;

	}

	
}
