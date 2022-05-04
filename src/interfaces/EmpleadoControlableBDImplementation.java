package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import clases.*;

public class EmpleadoControlableBDImplementation implements EmpleadoControlable {
	private Connection con;
	private PreparedStatement stmt;
	
	//Select
	final String busquedaEmple = "SELECT * FROM EMPLOYEE WHERE codEmple =?;";

	
	//Insert
	final String altaEmple = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?);";
	final String altaDoctor = "INSERT INTO DOCTOR VALUES (?, ?);";
	final String altaNurse = "INSERT INTO NURSE VALUES (?, ?);";
	final String altaContratoEmple = "INSERT INTO CONTRACT_EMPLOYEE VALUES (?,?,?,?);";
	final String altaContrato = "INSERT INTO CONTRACT VALUES (?, ?);";
	
	//Update
	final String updateEmpleado = "UPDATE EMPLOYEE SET codDepart = ?, nameEmployee = ?, lastNameEmployee1=?, lastNameEmployee2=?, activEmployee=? WHERE codEmployee = ?;";
	final String updateContratoEmple="UPDATE CONTRACT_EMPLOYEE SET dateStart=?, dateFinal=? WHERE codEmployee = ?;";
	final String updateContrato="UPDATE CONTRACT SET contractType=? WHERE codContract = ?;";
	
	//Delete
	
	
	
	private void openConnection() {
		try {
			// String url = "jdbc:mysql://localhost/nombreBaseDatos";
			String url = "jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";

			// con = DriverManager.getConnection(url+"?" +"user=____&password=_____");
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

	@Override
	public Empleado buscarEmpleado(String auxCodEmpleado, Contrato contrato, Doctor doctor, Enfermero enfermero) {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Empleado emple = null;

		// Abrir conexion
		this.openConnection();

		final String busquedaDoctor = "SELECT * FROM DOCTOR WHERE codEmple =?;";
		final String busquedaEnfermero = "SELECT * FROM  NURSE WHERE codEmple =?;";
		final String busquedaContratoEmple = "SELECT * FROM CONTRACT_EMPLOYEE WHERE codEmple =?;";
		final String busquedaContrato = "SELECT * FROM  WHERE codContract =?;";

		try {
			
			//TABLAS DE EMPLEADOS
			stmt = con.prepareStatement(busquedaEmple);
			stmt.setString(1, auxCodEmpleado);
			
			doctor.setCodEmpleado(busquedaDoctor);
			stmt.setString(1, auxCodEmpleado);


			rs = stmt.executeQuery();

			if (rs.next()) {
				emple = new Empleado();
				emple.setCodEmpleado(auxCodEmpleado);
				emple.setCodDepartamento(rs.getString("codDepartamento"));
				emple.setDniEmpleado((rs.getString("dniEmpleado")));
				emple.setNombreEmpleado((rs.getString("nombreEmpleado")));
				emple.setApellidosEmpleado(rs.getString("apellidoEmpleado"));
				emple.setActivoEmpleado(rs.getBoolean("activoEmpleado"));
				

			} else {
				emple = null;
			}

			if (rs != null) {
				rs.close();
			}

			// Cerrar conexion
			this.closeConnection();

		} catch (SQLException el) {
			el.printStackTrace();
		}

		return emple;
	}

	@Override
	public void altaEmpleado(Empleado emple, Contrato contrato, Doctor doctor, Enfermero enfermero) {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		// Abrir conexion
		this.openConnection();
		
		

			try {
				
				//TABLAS DE EMPLEADOS
				stmt = con.prepareStatement(altaEmple);
				stmt.setString(1, emple.getCodEmpleado());
				stmt.setString(2, emple.getCodDepartamento());
				stmt.setString(3, emple.getDniEmpleado());
				stmt.setString(4, emple.getNombreEmpleado());
				stmt.setString(5, emple.getApellidosEmpleado());//Dividir apellido 1 y 2!!!!!
				stmt.setBoolean(6, emple.isActivoEmpleado());
				
				stmt.executeUpdate();
				
				
				stmt = con.prepareStatement(altaDoctor);
				stmt.setString(1, doctor.getCodEmpleado());
				stmt.setString(2, doctor.getEspecialidades());
				
				stmt.executeUpdate();
				
				stmt = con.prepareStatement(altaNurse);
				stmt.setString(1, enfermero.getCodEmpleado());
				stmt.setString(2, enfermero.getHorario());
				
				stmt.executeUpdate();
				
				
				//TABLAS DE CONTRATOS
				stmt = con.prepareStatement(altaContratoEmple);
				stmt.setString(1, emple.getCodEmpleado());
				stmt.setString(2, contrato.getCodContrato());
				stmt.setDate(3, contrato.getFechaInicio());
				stmt.setDate(4, contrato.getFechaFin());
				
				stmt.executeUpdate();
				
				
				stmt = con.prepareStatement(altaContrato);
				stmt.setString(1, contrato.getCodContrato());
				stmt.setString(2, contrato.getTipoContrato());
				
				stmt.executeUpdate();
				
				
				
				// Cerrar conexion
				this.closeConnection();

			} catch (SQLException el) {
				el.printStackTrace();
			}

	}

	@Override
	public ArrayList<Empleado> listarEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarEmpleado(Empleado emple, Contrato contrato, Doctor doctor, Enfermero enfermero) {
		// Abrir conexion
		this.openConnection();

		boolean update = false;

		// Meter valores dentro del stmt
		try {
			
			//TABLAS DE EMPLEADOS
			stmt = con.prepareStatement(updateEmpleado);
			stmt.setString(1, emple.getCodDepartamento());
			stmt.setString(2, emple.getNombreEmpleado());
			stmt.setString(3, emple.getApellidosEmpleado());//Dividir apellido 1 y 2!!!!!
			stmt.setString(4, emple.getApellidosEmpleado());
			stmt.setBoolean(5, emple.isActivoEmpleado());
			stmt.setString(6, emple.getCodEmpleado());
			
			
			//TABLAS DE CONTRATOS
			stmt = con.prepareStatement(updateContratoEmple);
			stmt.setDate(1, contrato.getFechaInicio());
			stmt.setDate(2, contrato.getFechaFin());
			stmt.setString(3, emple.getCodEmpleado());
			
			
			stmt = con.prepareStatement(updateContrato);
			stmt.setString(1, contrato.getTipoContrato());
			stmt.setString(2, contrato.getCodContrato());

			if (stmt.executeUpdate() == 1) {
				update = true;
			}

			// Cerrar conexion
			closeConnection();

		} catch (SQLException el) {
			el.printStackTrace();
		}

		return update;
	}


	@Override
	public void eliminarEmpleado(Empleado emple, Contrato contrato, Doctor doctor, Enfermero enfermero) {
		// Abrir conexion
				this.openConnection();

				// Meter valores dentro del stmt
				try {
					String deleteEmpleado = "DELETE FROM EMPLOYEE WHERE codEmployee = ?;";
					stmt = con.prepareStatement(deleteEmpleado);
					stmt.setString(1, emple.getCodEmpleado());

					
					stmt.executeUpdate();
					
					String deleteContratoEmple = "DELETE FROM CONTRACT_EMPLOYEE WHERE codEmployee = ?;";
					stmt = con.prepareStatement(deleteContratoEmple);
					stmt.setString(1, emple.getCodEmpleado());
					
					
					
					// Cerrar conexion
					closeConnection();

				} catch (SQLException el) {
					el.printStackTrace();
				}
			}

	}
