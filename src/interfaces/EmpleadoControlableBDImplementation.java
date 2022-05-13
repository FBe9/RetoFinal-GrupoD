package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import clases.*;
import exceptions.CreateSqlException;

/**
 * 
 * @author Nerea
 *
 */
public class EmpleadoControlableBDImplementation implements EmpleadoControlable {
	private Connection con;
	private PreparedStatement stmt;
	DBconnection db = new DBconnection();
	private CreateSqlException ex;

	// Select
	final String busquedaEmple = "SELECT * FROM EMPLOYEE WHERE codEmple = ? AND codDepart= (SELECT codDepart FROM DEPART WHERE nameDepart = ?);";
	final String busquedaDoctor = "SELECT * FROM DOCTOR WHERE codEmple =?;";
	final String busquedaEnfermero = "SELECT * FROM  NURSE WHERE codEmple =?;";
	final String busquedaContratoEmple = "SELECT * FROM CONTRACT_EMPLOYEE WHERE codEmple =?;";
	final String busquedaContrato = "SELECT * FROM  WHERE codContract =?;";
	final String buscarTipoContrato = "SELECT contractType FROM contract_type";
	final String buscarCodDepartamentos = "SELECT codDepart FROM DEPART";
	final String buscarHorarios = "SELECT distinct schedule FROM NURSE";
	final String buscarEspecialidades = "SELECT specialty1, specialty2, specialty3, specialty4, specialty5 FROM DEPART WHERE codDepart = ?";
	final String loginUsuario = "SELECT codEmployee, typeEmployee, passwd FROM EMPLOYEE WHERE codEmployee = ? AND passwd = ?;";

	// Insert
	final String altaEmple = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?);";
	final String altaDoctor = "INSERT INTO DOCTOR VALUES (?, ?);";
	final String altaNurse = "INSERT INTO NURSE VALUES (?, ?);";
	final String altaContratoEmple = "INSERT INTO CONTRACT_EMPLOYEE VALUES (?,?,?,?);";
	final String altaContrato = "INSERT INTO CONTRACT VALUES (?, ?);";

	// Listado de tablas (3 atributos)
	final String listEmpleTabla = "SELECT codEmployee, nameEmployee, typeEmployee FROM EMPLOYEE";
	final String listEmpleTablaFiltro = "SELECT codEmployee, nameEmployee, typeEmployee FROM EMPLOYEE WHERE codEmployee = ? OR nameEmployee = ? OR typeEmployee = ?;";

	// Update
	final String updateEmpleado = "UPDATE EMPLOYEE SET codDepart = ?, nameEmployee = ?, lastNameEmployee1 = ?, lastNameEmployee2 = ?, activEmployee = ?, typeEmployee = ? WHERE codEmployee = ?;";
	final String updateDoctor = "UPDATE EMPLOYEE SET specialty_doc = ? ;";
	final String updateEnfermero = "UPDATE EMPLOYEE SET schedule  = ? ;";
	final String updateContratoEmple = "UPDATE CONTRACT_EMPLOYEE SET dateStart = ?, dateFinal = ? WHERE codEmployee = ?;";
	final String updateContrato = "UPDATE CONTRACT SET contractType=? WHERE codContract = ?;";

	// Delete

	// Busca un objeto de tipo Empleado y te lo devuelve
	@Override
	public Empleado buscarEmpleado(String auxCodEmpleado, String auxNomDepart) {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Empleado emple = null;

		// Abrir conexion
		con = db.openConnection();

		try {

			stmt = con.prepareStatement(busquedaEmple);
			stmt.setString(1, auxCodEmpleado);
			stmt.setString(2, auxNomDepart);

			rs1 = stmt.executeQuery();

			if (rs1.next()) {
				if (rs1.getString(8).equalsIgnoreCase("Doctor"))
					emple = new Doctor();
				else
					emple = new Enfermero();

				emple.setCodEmpleado(rs1.getString(1));
				emple.setCodDepartamento(rs1.getString(2));
				emple.setDniEmpleado((rs1.getString(3)));
				emple.setNombreEmpleado((rs1.getString(4)));
				emple.setApellido1Empleado(rs1.getString(5));
				emple.setApellido2Empleado(rs1.getString(6));
				emple.setActivoEmpleado(rs1.getBoolean(7));
				emple.setTipoEmpleado(rs1.getString(8));

			} else {
				emple = null;
			}

			if (emple instanceof Doctor) {
				stmt = con.prepareStatement(busquedaDoctor);
				stmt.setString(1, auxCodEmpleado);

				rs2 = stmt.executeQuery();

				if (rs2.next()) {
					((Doctor) emple).setEspecialidad(rs2.getString(1));
				} else {
					emple = null;
				}

			} else {
				stmt = con.prepareStatement(busquedaEnfermero);
				stmt.setString(1, auxCodEmpleado);

				rs2 = stmt.executeQuery();

				if (rs2.next()) {
					((Enfermero) emple).setHorario(rs2.getString(1));
				} else {
					emple = null;
				}

			}

		} catch (SQLException e) {

		} finally {
			if (rs1 != null && rs2 != null) {
				try {
					rs1.close();
					rs2.close();
				} catch (SQLException ex) {
					ex = new CreateSqlException("Error, paciente no encontrado");
					// throw ex;
				}
			}
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error despues del finally" + e.getMessage());
			}
		}

		return emple;
	}

	// Busca un objeto de tipo Contrato y te lo devuelve
	@Override
	public Contrato buscarContrato(String auxCodEmpleado, String auxCodContrato) {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Contrato contrato = null;

		// Abrir conexion
		con = db.openConnection();

		try {
			// Tabla Contrato ----> COD DE EMPLE, NS COMO PASARLO!!!
			stmt = con.prepareStatement(busquedaContratoEmple);
			stmt.setString(1, auxCodContrato);// (ARREGLO TEMPORAL)

			rs1 = stmt.executeQuery();

			if (rs1.next()) {
				contrato = new Contrato();
				contrato.setCodContrato(rs1.getString(1));
				contrato.setTipoContrato(rs1.getString(2));

			} else {
				contrato = null;
			}

			// Tabla relacion de Contrato con Empleado
			stmt = con.prepareStatement(busquedaContrato);
			stmt.setString(1, auxCodEmpleado);

			rs2 = stmt.executeQuery();

			if (rs2.next()) {
				contrato.setCodContrato(rs2.getString(1));
				contrato.setFechaInicio(rs2.getDate(2));
				contrato.setFechaFin(rs2.getDate(3));

			} else {
				contrato = null;
			}
		} catch (SQLException el) {
			el.printStackTrace();

		} finally

		{
			if (rs1 != null && rs2 != null) {
				try {
					rs1.close();
					rs2.close();
				} catch (SQLException ex) {
					ex = new CreateSqlException("Error, paciente no encontrado");
					// throw ex;
				}
			}
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error despues del finally" + e.getMessage());
			}
		}

		return contrato;
	}

	@Override
	public ArrayList<String> buscarTipoContrato() {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> tiposContrato = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// Tabla Contrato ----> COD DE EMPLE, NS COMO PASARLO!!!
			stmt = con.prepareStatement(buscarTipoContrato);

			rs = stmt.executeQuery();

			while (rs.next()) {
				tiposContrato.add(rs.getString(1));
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

		return tiposContrato;

	}

	@Override
	public ArrayList<String> buscarEspecialidades(String Departamento) {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> especialidades = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// Tabla Contrato ----> COD DE EMPLE, NS COMO PASARLO!!!
			stmt = con.prepareStatement(buscarEspecialidades);

			stmt.setString(1, Departamento);

			rs = stmt.executeQuery();

			while (rs.next()) {
				especialidades.add(rs.getString(1));
				especialidades.add(rs.getString(2));
				especialidades.add(rs.getString(3));
				especialidades.add(rs.getString(4));
				especialidades.add(rs.getString(5));
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

		return especialidades;

	}

	@Override
	public ArrayList<String> buscarCodDepartamentos() {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> codDepartamentos = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// Tabla Contrato ----> COD DE EMPLE, NS COMO PASARLO!!!
			stmt = con.prepareStatement(buscarCodDepartamentos);

			rs = stmt.executeQuery();

			while (rs.next()) {
				codDepartamentos.add(rs.getString(1));
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

		return codDepartamentos;

	}

	@Override
	public ArrayList<String> buscarHorarios() {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> horarios = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// Tabla Contrato ----> COD DE EMPLE, NS COMO PASARLO!!!
			stmt = con.prepareStatement(buscarHorarios);

			rs = stmt.executeQuery();

			while (rs.next()) {
				horarios.add(rs.getString(1));
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

		return horarios;

	}

	// Añade un Empleado nuevo a la base de datos
	@Override
	public void altaEmpleado(Empleado emple, Contrato contrato) {
		// Abrir conexion
		con = db.openConnection();

		try {

			// TABLAS DE EMPLEADOS
			stmt = con.prepareStatement(altaEmple);
			stmt.setString(1, emple.getCodEmpleado());
			stmt.setString(2, emple.getCodDepartamento());
			stmt.setString(3, emple.getDniEmpleado());
			stmt.setString(4, emple.getNombreEmpleado());
			stmt.setString(5, emple.getApellido1Empleado());
			stmt.setString(6, emple.getApellido2Empleado());
			stmt.setBoolean(7, emple.isActivoEmpleado());
			stmt.setString(8, emple.getTipoEmpleado());

			stmt.executeUpdate();

			if (emple.getTipoEmpleado().equalsIgnoreCase("Doctor")) {
				stmt = con.prepareStatement(altaDoctor);
				stmt.setString(1, emple.getCodEmpleado());
				stmt.setString(2, ((Doctor) emple).getEspecialidad());

			} else {

				stmt = con.prepareStatement(altaNurse);
				stmt.setString(1, emple.getCodEmpleado());
				stmt.setString(2, ((Enfermero) emple).getHorario());

			}

			stmt.executeUpdate();

			// TABLAS DE CONTRATOS
			stmt = con.prepareStatement(altaContrato);
			stmt.setString(1, contrato.getCodContrato());
			stmt.setString(2, contrato.getTipoContrato());

			stmt.executeUpdate();

			stmt = con.prepareStatement(altaContratoEmple);
			stmt.setString(1, emple.getCodEmpleado());
			stmt.setString(2, contrato.getCodContrato());
			stmt.setDate(3, contrato.getFechaInicio());
			stmt.setDate(4, contrato.getFechaFin());

			stmt.executeUpdate();

		} catch (SQLException el) {
			el.printStackTrace();

			// throw new CreateException(e1.getMessage());
		} finally {
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public ArrayList<Empleado> listarEmpleado() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Empleado emple = null;

		ArrayList<Empleado> empleados = new ArrayList<>();

		con = db.openConnection();

		try {
			stmt = con.prepareStatement(listEmpleTabla);

			rs = stmt.executeQuery();

			while (rs.next()) {
				emple = new Empleado();
				emple.setCodEmpleado(rs.getString(1));
				emple.setNombreEmpleado(rs.getString(2));
				emple.setTipoEmpleado(rs.getString(3));

				empleados.add(emple);
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
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return empleados;

	}

	// Cambia valores de un Empleado previamente registrado en la base de datos
	@Override
	public boolean modificarEmpleado(Empleado emple, Contrato contrato) {
		// Abrir conexion
		con = db.openConnection();

		boolean update = false;

		// Meter valores dentro del stmt
		try {

			// TABLAS DE EMPLEADOS
			stmt = con.prepareStatement(updateEmpleado);
			stmt.setString(1, emple.getCodDepartamento());
			stmt.setString(2, emple.getNombreEmpleado());
			stmt.setString(3, emple.getApellido1Empleado());
			stmt.setString(4, emple.getApellido2Empleado());
			stmt.setBoolean(5, emple.isActivoEmpleado());
			stmt.setString(5, emple.getTipoEmpleado());
			stmt.setString(6, emple.getCodEmpleado());

			if (emple.getTipoEmpleado().equalsIgnoreCase("Doctor")) {
				stmt = con.prepareStatement(updateDoctor);
				stmt.setString(1, ((Doctor) emple).getEspecialidad());

			} else {
				stmt = con.prepareStatement(updateEnfermero);
				stmt.setString(1, ((Enfermero) emple).getHorario());
			}
			// TABLAS DE CONTRATOS
			stmt = con.prepareStatement(updateContratoEmple);
			stmt.setDate(1, contrato.getFechaInicio());
			stmt.setDate(2, contrato.getFechaFin());
			stmt.setString(3, emple.getCodEmpleado());

			stmt = con.prepareStatement(updateContrato);
			stmt.setString(1, contrato.getTipoContrato());
			stmt.setString(2, contrato.getCodContrato());

			stmt.executeUpdate();

			if (stmt.executeUpdate() > 0) {
				update = true;
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return update;
	}

	// Elimina un Empleado existente de la base de datos (Borrado logico)
	@Override
	public boolean eliminarEmpleado(Empleado emple, String auxCodEmple) {
		boolean update = false;

		// Abrir conexion
		con = db.openConnection();

		// Meter valores dentro del stmt
		try {
			String deleteEmpleado = "UPDATE FROM EMPLOYEE SET activEmployee = ? WHERE codEmployee = ?;";
			stmt = con.prepareStatement(deleteEmpleado);
			stmt.setBoolean(1, false);
			stmt.setString(2, auxCodEmple);

			stmt.executeUpdate();
			if (stmt.executeUpdate() > 0) {
				update = true;
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
		return update;
	}

	@Override
	public Empleado loginUsuario(String codigoDelUsuario, String contrasenaDelUsuario) {
		ResultSet rs = null;
		Empleado empleado = null;

		try {

			con = db.openConnection();

			stmt = con.prepareStatement(loginUsuario);

			stmt.setString(1, codigoDelUsuario);
			stmt.setString(2, contrasenaDelUsuario);

			rs = stmt.executeQuery();

			if (rs.next()) {
				empleado = new Empleado();
				empleado.setCodEmpleado(rs.getString(1));
				empleado.setTipoEmpleado(rs.getString(2));
				empleado.setPasswdEmpleado(rs.getString(3));
        
			} else {
				empleado = null;
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
		return empleado;
	}
}
