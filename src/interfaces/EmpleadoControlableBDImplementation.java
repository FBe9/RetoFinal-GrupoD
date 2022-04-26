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
	public Empleado buscarEmpleado(String auxCodEmpleado) {
		/// Tenemos q definir resulSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Empleado auxEmple = null;

		// Abrir conexion
		this.openConnection();

		String busquedaEmple = "SELECT * FROM EMPLEADO WHERE codEmple =?;";

		try {
			stmt = con.prepareStatement(busquedaEmple);
			stmt.setString(1, auxCodEmpleado);

			rs = stmt.executeQuery();

			if (rs.next()) {
				auxEmple = new Empleado();
				auxEmple.setCodEmpleado(auxCodEmpleado);
				auxEmple.setCodDepartamento(rs.getString("codDepartamento"));
				auxEmple.setDniEmpleado((rs.getString("dniEmpleado")));
				auxEmple.setNombreEmpleado((rs.getString("nombreEmpleado")));
				auxEmple.setApellidosEmpleado(rs.getString("apellidoEmpleado"));
				auxEmple.setActivoEmpleado(rs.getBoolean("activoEmpleado"));
				
			} else {
				auxEmple = null;
			}

			if (rs != null) {
				rs.close();
			}

			// Cerrar conexion
			this.closeConnection();

		} catch (SQLException el) {
			el.printStackTrace();
		}

		return auxEmple;
	}

	@Override
	public void altaEmpleado(Empleado auxEmple) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Empleado> listarEmpleado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modificarEmpleado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eliminarEmpleado() {
		// TODO Auto-generated method stub

	}

}
