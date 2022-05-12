package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.Usuario;

public class UsuarioLoginControlableBDImplementation implements UsuarioLoginControlable{

	private Connection conexion;
	private PreparedStatement psttm;
	
	// QUERYS PARA MYSQL

		final String loginUsuario = "SELECT CODEMPLOYEE, TYPEEMPLOYEE, PASSWD FROM EMPLOYEE WHERE CODEMPLOYEE = ? AND PASSWD = ?;";
		
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
	
	@Override
	public Usuario loginUsuario(String codigoDelUsuario, String contrasenaDelUsuario) {
		ResultSet rs = null;
		Usuario usuario = null;
				
		try {
			
			openConnection();
			
			psttm = conexion.prepareStatement(loginUsuario);
			
			psttm.setString(1, codigoDelUsuario);
			psttm.setString(2, contrasenaDelUsuario);
			
			rs = psttm.executeQuery();
			
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setCodigoDelUsuario(rs.getString(1));
				usuario.setContrasenaDelUsuario(rs.getString(9));
				usuario.setTipoDeUsuario(rs.getString(8));
			}else {
				usuario = null;
			}
			
			
		}catch (SQLException e) {
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
		return usuario;
	}

}
