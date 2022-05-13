package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Esta clase abre la base de datos con un fichero de configuracion
 * @author Emil
 *
 */
public class DBconnection {

	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;

	public DBconnection() {

		configFile = ResourceBundle.getBundle("interfaces.config");
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");

	}

	public Connection openConnection() {
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			
		}
		return conexion;
	}

	public void closeConnection(PreparedStatement stmt, Connection conexion) throws SQLException {

		if (stmt != null)
			stmt.close();
		if (conexion != null)
			conexion.close();

	}

}
