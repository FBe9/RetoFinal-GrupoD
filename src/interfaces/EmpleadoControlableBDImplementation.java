package interfaces;

import java.sql.Connection;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import clases.*;
import exceptions.CreateSqlException;

/**
 * Esta es la implementacion de la interfaz EmpleadoControlable y contiene la
 * implementacion de acceso a datos para la funcionalidad del empleado
 * 
 * @author Nerea
 */
public class EmpleadoControlableBDImplementation implements EmpleadoControlable {
	private Connection con;
	private PreparedStatement stmt;
	DBconnection db = new DBconnection();
	private CreateSqlException ex;

	// Select
	final String busquedaEmple = "SELECT * FROM EMPLOYEE WHERE codEmployee = ?;";
	final String busquedaDoctor = "SELECT * FROM DOCTOR WHERE codEmployee =?;";
	final String busquedaEnfermero = "SELECT * FROM  NURSE WHERE codEmployee =?;";
	final String busquedaContratoEmple = "SELECT DISTINCT  CE.*, C.contractType FROM CONTRACT C, CONTRACT_EMPLOYEE CE WHERE codEmployee = ? AND C.codContract = CE.codContract;";
	final String buscarTipoContrato = "SELECT contractType FROM CONTRACT_TYPE";
	final String buscarCodDepartamentos = "SELECT codDepart FROM DEPART";
	final String buscarHorarios = "SELECT DISTINCT schedule FROM NURSE";
	final String buscarEspecialidades = "SELECT specialty1, specialty2, specialty3, specialty4, specialty5 FROM DEPART WHERE codDepart = ?";
	final String loginUsuario = "SELECT codEmployee, typeEmployee, passwd FROM EMPLOYEE WHERE codEmployee = ? AND passwd = ?;";

	// Insert
	final String altaEmple = "INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?,?,?,'abcd*1234');";
	final String altaDoctor = "INSERT INTO DOCTOR VALUES (?, ?);";
	final String altaNurse = "INSERT INTO NURSE VALUES (?, ?);";
	final String altaContratoEmple = "INSERT INTO CONTRACT_EMPLOYEE VALUES (?,?,?,?);";
	final String altaContrato = "INSERT INTO CONTRACT VALUES (?, ?);";

	// Listado de tablas (3 atributos)
	final String buscarEmpleadosTabla = "SELECT codEmployee, nameEmployee, typeEmployee FROM EMPLOYEE WHERE typeEmployee != 'Administrador'";

	// Update
	final String updateEmpleado = "UPDATE EMPLOYEE SET codDepart = ?, nameEmployee = ?, lastNameEmployee1 = ?, lastNameEmployee2 = ?, activEmployee = ?, typeEmployee = ? WHERE codEmployee = ?;";
	final String updateDoctor = "UPDATE DOCTOR SET specialty_doc = ? WHERE codEmployee = ?;";
	final String updateEnfermero = "UPDATE NURSE SET schedule  = ? WHERE codEmployee = ?;";
	final String updateContratoEmple = "UPDATE CONTRACT_EMPLOYEE SET dateStart = ?, dateFinal = ? WHERE codEmployee = ?;";
	final String updateContrato = "UPDATE CONTRACT SET contractType=? WHERE codContract = ?;";
	final String updateActivoEmpleado = "UPDATE EMPLOYEE SET activEmployee = ? WHERE codEmployee = ?;";

	/**
	 * Busca un objeto de tipo Empleado y te lo devuelve.
	 * 
	 * @param auxCodEmpleado El codigo del empleado
	 * @return un objeto Empleado con los datos del empleado
	 */
	@Override
	public Empleado buscarEmpleado(String auxCodEmpleado) throws CreateSqlException {

		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs1 = null;
		Empleado emple = null;

		// Abrir conexion
		con = db.openConnection();

		try {
			// TABLA EMPLOYEE
			stmt = con.prepareStatement(busquedaEmple);
			stmt.setString(1, auxCodEmpleado);

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
			}
		
		} catch (SQLException e) {
			String error =("Error en la busqueda de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			if (rs1 != null ) {
				try {
					rs1.close();
				} catch (SQLException ex) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return emple;
	}
	
	/**
	 * Busca un objeto de tipo Contrato y te lo devuelve
	 * 
	 * @param auxCodEmpleado El codigo del empleado y auxCodContrato El codigo del
	 *                       contrato
	 * @return un objeto Contrato con los datos del contrato
	 */
	@Override
	public Contrato buscarContrato(String auxCodEmpleado) throws CreateSqlException {

		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs1 = null;
		Contrato contrato = null;

		// Abrir conexion
		con = db.openConnection();

		try {
			// TABLA CONTRACT_EMPLOYEE
			stmt = con.prepareStatement(busquedaContratoEmple);
			stmt.setString(1, auxCodEmpleado);

			rs1 = stmt.executeQuery();

			if (rs1.next()) {
				contrato = new Contrato();
				contrato.setCodContrato(rs1.getString(2));
				contrato.setFechaInicio(rs1.getDate(3));
				contrato.setFechaFin(rs1.getDate(4));
				contrato.setTipoContrato(rs1.getString(5));
			}
			
		} catch (SQLException el) {
			System.out.println(el.getMessage());

		} finally
		
		{
			if (rs1 != null) {
				try {
					rs1.close();
					
				} catch (SQLException ex) {
					String error = ("Error al cerrar la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
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
	
	/**
	 * Busca en las tablas de Doctor y Enfermero y trae una especialidad o un horario
	 * 
	 * @param auxCodEmpleado EL codigo del empleado
	 * @return especialidad u horario dependiendo del tipo del empleado
	 */
	public String buscarEspecialidadHorario(String auxCodEmpleado) throws CreateSqlException{
		ResultSet rs1 = null;
		String espeHora = null;
		
		con = db.openConnection();
		try {
				stmt = con.prepareStatement(busquedaDoctor);
				stmt.setString(1, auxCodEmpleado);

				rs1 = stmt.executeQuery();

				if (rs1.next()) {
					espeHora = rs1.getString(1);
				}
		
				// TABLA NURSE
				stmt = con.prepareStatement(busquedaEnfermero);
				stmt.setString(1, auxCodEmpleado);

				rs1 = stmt.executeQuery();

				if (rs1.next()) {
					espeHora = rs1.getString(1);
				}
} catch (SQLException el) {
			String error =("Error en la busqueda de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			if (rs1 != null ) {
				try {
					rs1.close();
				} catch (SQLException ex) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}
		
		return espeHora;
	}

	/**
	 * Busca los 3 tipos de contrato que hay y los vuelca a un ArrayList para poder
	 * usarlos en un comboBox
	 * 
	 * @return devuelve un ArrayList de Strings con los valores de tipo de contrato
	 *         cargados
	 */
	@Override
	public ArrayList<String> buscarTipoContrato() throws CreateSqlException {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> tiposContrato = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// TABLA CONTRACT_TYPE
			stmt = con.prepareStatement(buscarTipoContrato);

			rs = stmt.executeQuery();

			while (rs.next()) {
				tiposContrato.add(rs.getString(1));
			}

		} catch (SQLException e) {
			String error =("Error en la busqueda de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return tiposContrato;

	}

	/**
	 * Busca los codigos de departamento registrados y los vuelca a un ArrayList
	 * para poder usarlos en un comboBox
	 * 
	 * @return devuelve un ArrayList de Strings con los valores de los codigos de
	 *         cada departamento registrado
	 */
	@Override

	public ArrayList<String> buscarCodDepartamentos() throws CreateSqlException {

		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> codDepartamentos = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// TABLA DEPART
			stmt = con.prepareStatement(buscarCodDepartamentos);

			rs = stmt.executeQuery();

			while (rs.next()) {
				codDepartamentos.add(rs.getString(1));
			}

		} catch (SQLException e) {
			String error =("Error en la busqueda de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return codDepartamentos;

	}

	/**
	 * Busca los 5 tipos de especialidades que hay por cada departamento y los
	 * vuelca a un ArrayList para poder usarlos en un comboBox
	 * 
	 * @param departamento El codigo del departamento
	 * @return devuelve un ArrayList de Strings con los valores de las
	 *         especialidades dependendo del departamento
	 */
	@Override

	public ArrayList<String> buscarEspecialidades(String auxCodDepart) throws CreateSqlException{

		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> especialidades = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// TABLA DEPART
			stmt = con.prepareStatement(buscarEspecialidades);
			stmt.setString(1, auxCodDepart);

			rs = stmt.executeQuery();

			while (rs.next()) {
				especialidades.add(rs.getString(1));
				especialidades.add(rs.getString(2));
				especialidades.add(rs.getString(3));
				especialidades.add(rs.getString(4));
				especialidades.add(rs.getString(5));
			}

		} catch (SQLException e) {
			String error =("Error en la busqueda de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return especialidades;

	}

	/**
	 * Busca los 2 tipos de horarios que hay y los vuelca a un ArrayList para poder
	 * usarlos en un comboBox
	 * 
	 * @return devuelve un ArrayList de Strings con los valores de los horarios
	 */
	@Override
	public ArrayList<String> buscarHorarios() throws CreateSqlException {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;

		ArrayList<String> horarios = new ArrayList<>();

		// Abrir conexion
		con = db.openConnection();

		try {
			// TABLA NURSE
			stmt = con.prepareStatement(buscarHorarios);

			rs = stmt.executeQuery();

			while (rs.next()) {
				horarios.add(rs.getString(1));
			}

		} catch (SQLException e) {
			String error =("Error en la busqueda de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					String error = ("Error al terminar la Query de la BD");
					CreateSqlException exception = new CreateSqlException(error);
					throw exception;
				}
			}
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return horarios;

	}



	/**
	 * Introduce un Empleado nuevo a la base de datos
	 * 
	 * @param emple Un objeto de tipo Empleado, contrato Un objeto de tipo Contrato
	 *              y espHora El atributo que guarda una especialidad o un horario
	 */
	@Override
	public void altaEmpleado(Empleado emple, Contrato contrato, String espeHora) throws CreateSqlException{

		// Abrir conexion
		con = db.openConnection();

		try {

			// TABLA EMPLOYEE
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
				// TABLA DOCTOR
				stmt = con.prepareStatement(altaDoctor);
				stmt.setString(1, emple.getCodEmpleado());
				stmt.setString(2, espeHora);


			} else {
				// TABLA NURSE
				stmt = con.prepareStatement(altaNurse);
				stmt.setString(1, emple.getCodEmpleado());
				stmt.setString(2, espeHora);
			}

			stmt.executeUpdate();

			// TABLA CONTRACT
			stmt = con.prepareStatement(altaContrato);
			stmt.setString(1, contrato.getCodContrato());
			stmt.setString(2, contrato.getTipoContrato());

			stmt.executeUpdate();

			// TABLA CONTRACT_EMPLOYEE
			stmt = con.prepareStatement(altaContratoEmple);
			stmt.setString(1, emple.getCodEmpleado());
			stmt.setString(2, contrato.getCodContrato());
			stmt.setDate(3, contrato.getFechaInicio());
			stmt.setDate(4, contrato.getFechaFin());

			stmt.executeUpdate();

		} catch (SQLException el) {
			String error = ("Error en la introducci�n de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

	}


	/**
	 * Busca los empleados registrados y los vuelca a un ArrayList para poder
	 * usarlos en una tabla
	 * 
	 * @return un ArrayList de tipo Empleado
	 */
	public ArrayList<Empleado> listarEmpleadosTabla() throws CreateSqlException{

		ResultSet rs = null;
		Empleado emple = null;

		ArrayList<Empleado> empleados = new ArrayList<>();

		con = db.openConnection();

		try {
			// TABLA EMPLOYEE
			stmt = con.prepareStatement(buscarEmpleadosTabla);

			rs = stmt.executeQuery();

			while (rs.next()) {
				emple = new Empleado();
				emple.setCodEmpleado(rs.getString(1));
				emple.setNombreEmpleado(rs.getString(2));
				emple.setTipoEmpleado(rs.getString(3));

				empleados.add(emple);
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
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return empleados;

	}

	/**
	 * Cambia valores de un Empleado previamente registrado en la base de datos
	 * 
	 * @param emple Un objeto de tipo Empleado y contrato Un objeto de tipo Contrato
	 * @return un boolean para comprobar si se ha modificado
	 */
	@Override
	public boolean modificarEmpleado(Empleado emple, Contrato contrato,  String espeHora) throws CreateSqlException {

		// Abrir conexion
		con = db.openConnection();

		boolean update = false;

		try {

			// TABLA EMPLOYEE
			stmt = con.prepareStatement(updateEmpleado);
			stmt.setString(1, emple.getCodDepartamento());
			stmt.setString(2, emple.getNombreEmpleado());
			stmt.setString(3, emple.getApellido1Empleado());
			stmt.setString(4, emple.getApellido2Empleado());
			stmt.setBoolean(5, emple.isActivoEmpleado());
			stmt.setString(6, emple.getTipoEmpleado());
			stmt.setString(7, emple.getCodEmpleado());
			stmt.executeUpdate();
			
			if (emple.getTipoEmpleado().equalsIgnoreCase("Doctor")) {
				// TABLA DOCTOR
				stmt = con.prepareStatement(updateDoctor);
				stmt.setString(2, espeHora);
				stmt.setString(1, emple.getCodEmpleado());


			} else {
				// TABLA NURSE
				stmt = con.prepareStatement(updateEnfermero);
				stmt.setString(2, espeHora);
				stmt.setString(1, emple.getCodEmpleado());
			}
			stmt.executeUpdate();
			
			
			// TABLA CONTRACT_EMPLOYEE
			stmt = con.prepareStatement(updateContratoEmple);
			stmt.setDate(1, (Date) contrato.getFechaInicio());
			stmt.setDate(2, (Date) contrato.getFechaFin());
			stmt.setString(3, emple.getCodEmpleado());
			
			stmt.executeUpdate();
			// TABLA CONTRACT
			stmt = con.prepareStatement(updateContrato);
			stmt.setString(2, contrato.getCodContrato());
			stmt.setString(1, contrato.getTipoContrato());
		

			stmt.executeUpdate();

			if (stmt.executeUpdate() > 0) {
				update = true;
			}
		} catch (SQLException e1) {
			String error = ("Error en la modificaci�n de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}

		return update;
	}

	/**
	 * Elimina un Empleado existente de la base de datos cambiando su atributo
	 * activeEmploye a false
	 *
	 * @param emple Un objeto de tipo Empleado y auxCodEmple El codigo del empleado
	 * @return un boolean para comprobar si se ha modificado
	 */
	@Override
	public boolean eliminarEmpleado(Empleado emple, String auxCodEmple) throws CreateSqlException {
		boolean update = false;

		// Abrir conexion
		con = db.openConnection();

		try {
			// TABLA EMPLOYEE
			stmt = con.prepareStatement(updateActivoEmpleado);
			stmt.setBoolean(1, false);
			stmt.setString(2, auxCodEmple);

			stmt.executeUpdate();
			if (stmt.executeUpdate() > 0) {
				update = true;
			}
		} catch (SQLException e1) {
			String error = ("Error en la eliminaci�n de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			try {
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}
		}
		return update;
	}

	/**
	 * Te conecta a la aplicacion y comprueba tu tipo para abrir las ventanas de
	 * administrador o empleados despues
	 *
	 * @param codigoDelUsuario El codigo del empleado y contrasenaDelUsuario
	 *                         contrasenia del usuario
	 * @return un objeto de tipo Empleado
	 */
	@Override
	public Empleado loginUsuario(String codigoDelUsuario, String contrasenaDelUsuario) throws CreateSqlException {
		ResultSet rs = null;
		Empleado empleado = null;

		try {
			// Abrir conexion
			con = db.openConnection();

			// TABLA EMPLOYEE
			stmt = con.prepareStatement(loginUsuario);
			stmt.setString(1, codigoDelUsuario);
			stmt.setString(2, contrasenaDelUsuario);

			rs = stmt.executeQuery();

			if (rs.next()) {
				empleado = new Empleado();
				empleado.setCodEmpleado(rs.getString(1));
				empleado.setTipoEmpleado(rs.getString(2));
				empleado.setPasswdEmpleado(rs.getString(3));

			}
		} catch (SQLException e1) {
			String error = ("Error en verificacion de datos en la BD");
			CreateSqlException exception = new CreateSqlException(error);
			throw exception;
		} finally {
			try {
				// Cerrar conexion
				db.closeConnection(stmt, con);
			} catch (SQLException e) {
				String error = ("Error al cerrar la BD");
				CreateSqlException exception = new CreateSqlException(error);
				throw exception;
			}

		}
		return empleado;
	}
}
