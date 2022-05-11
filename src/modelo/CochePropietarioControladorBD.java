package modelo;

import java.awt.List;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class CochePropietarioControladorBD implements CochePropietarioControlador{
	
	private Connection con;
	private PreparedStatement stmt;

	// Sentencias SQL
	final String INSERTprop = "INSERT INTO propietario(id, nombre, telefono) VALUES( ?, ?, ?)";
	final String OBTENERprop = "SELECT * FROM propietario WHERE id = ?";
	final String OBTENERprops = "SELECT * FROM propietario";
	final String UPDATEprop = "UPDATE propietario SET nombre = ?, telefono= ? WHERE id = ?";
	final String DELETEprop = "DELETE FROM propietario WHERE id = ?";
	
	final String INSERTcoc = "INSERT INTO coche(matricula, marca, modelo, edad, precio, idpropietario) VALUES( ?, ?, ?, ?, ?, ?)";
	final String OBTENERcoc = "SELECT * FROM coche WHERE matricula = ?";
	final String OBTENERcocs = "SELECT * FROM coche";
	final String UPDATEcoc = "UPDATE coche SET marca= ? , modelo= ? , edad= ? , precio= ? , idpropietario= ? WHERE matricula = ?";
	final String DELETEcoc = "DELETE FROM coche WHERE matricula = ?";
	
	final String OBTENERcochesPropietario = "SELECT * FROM coche WHERE idpropietario = ?";
	/*
	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost/bdvehiculos";
		//	con = DriverManager.getConnection(url + "?" + "user=root&password=tartanga");
			con = DriverManager.getConnection(url + "?" + "user=root");
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}

	}
	*/
	private void openConnection(){
		 try {
		  //String url = "jdbc:mysql://localhost/nombreBaseDatos";
		  String url ="jdbc:mysql://localhost:3306/bdcoches?serverTimezone=Europe/Madrid&useSSL=false";
		  //con =  DriverManager.getConnection(url+"?" +"user=____&password=_____");
		  con =  DriverManager.getConnection(url,"root" ,"abcd*1234");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		 }	
		}

	 //Metodo que nos permite desconectarnos de la base de datos
	 // @throws SQLException en caso de que ocurra algun error
	 private void closeConnection() throws SQLException {
		System.out.println("Conexion Cerrada.");
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
		System.out.println("------------------------");
	}

	@Override
	public Propietario buscarPropietario(String wId) {
// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Propietario prop = null;

		// Abrimos la conexión
		this.openConnection();
		//final String OBTENERprop = "SELECT * FROM propietario WHERE id = ?";
		try {
			stmt = con.prepareStatement(OBTENERprop);

			// Cargamos los parámetros
			stmt.setString(1, wId);

			rs = stmt.executeQuery();

			if (rs.next()) {
				prop = new Propietario();
				prop.setId(wId);
				prop.setNombre(rs.getString("nombre"));
				prop.setTelefono(rs.getString("telefono"));
			} else
				prop = null;
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}

		return prop;
	}

	@Override
	public void addPropietario(Propietario prop) {
		// Abrimos la conexión
		this.openConnection();

		// Meto los valores del propietario dentro del stmt:
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			//final String INSERTprop = "INSERT INTO propietario(id, nombre, telefono) VALUES( ?, ?, ?)";
			stmt = con.prepareStatement(INSERTprop);

			stmt.setString(1, prop.getId());
			stmt.setString(2, prop.getNombre());
			stmt.setString(3, prop.getTelefono());

			stmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public Set<Propietario> listarPropietarios() {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Propietario prop;
		Set <Propietario> propietarios = new HashSet<>();

		// Abrimos la conexión
		this.openConnection();
		
		try {
			//final String OBTENERprops = "SELECT * FROM propietario";
			stmt = con.prepareStatement(OBTENERprops);

			rs = stmt.executeQuery();

			// Leemos de uno en uno los propietarios devueltos en el ResultSet
			while (rs.next()) {
				prop = new Propietario();
				prop.setId(rs.getString("id"));
				prop.setNombre(rs.getString("nombre"));
				prop.setTelefono(rs.getString("telefono"));
				propietarios.add(prop);
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return propietarios;
	}

	@Override
	public boolean modificarPropietario(Propietario prop) {
		boolean cambios=false;
		// Abrimos la conexión
		this.openConnection();

		// Meto los valores del propietario dentro del stat:
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			//final String UPDATEprop = "UPDATE propietario SET nombre = ?, telefono= ? WHERE id = ?";
			stmt = con.prepareStatement(UPDATEprop);

			stmt.setString(1, prop.getNombre());
			stmt.setString(2, prop.getTelefono());
			stmt.setString(3, prop.getId());

			if (stmt.executeUpdate()==1) 
				cambios=true;
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
		return cambios;
	}

	@Override
	public void eliminarPropietario(Propietario prop) {
		// Abrimos la conexión
		this.openConnection();

		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(DELETEprop);

			stmt.setString(1, prop.getId());

			stmt.executeUpdate();
			
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Coche buscarCoche(String matricula) {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
		ResultSet rs = null;
		Coche coc = null;

		// Abrimos la conexión
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERcoc);

			// Cargamos los parámetros
			stmt.setString(1, matricula);

			rs = stmt.executeQuery();

			if (rs.next()) {
				coc = new Coche();
				coc.setMatricula(matricula);
				coc.setMarca(rs.getString("marca"));
				coc.setModelo(rs.getString("modelo"));
				coc.setEdad(rs.getInt("edad"));
				coc.setPrecio(rs.getDouble("precio"));
				coc.setIdPropietario(rs.getString("idpropietario"));
			} else
				coc = null;
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}

		return coc;
	}

	@Override
	public void altaCoche(Coche coche) {
		// Abrimos la conexión
		this.openConnection();
//final String INSERTcoc = "INSERT INTO coche(matricula, marca, modelo, edad, precio, idpropietario) VALUES( ?, ?, ?, ?, ?, ?)";
		// Meto los valores del coche dentro del stmt:
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(INSERTcoc);

			stmt.setString(1, coche.getMatricula());
			stmt.setString(2, coche.getMarca());
			stmt.setString(3, coche.getModelo());
			stmt.setInt(4, coche.getEdad());
			stmt.setDouble(5, coche.getPrecio());
			stmt.setString(6, coche.getIdPropietario());

			stmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public Map<String, Coche> listarCoches() {
		// Tenemos que definir el ResultSet para recoger el resultado de la consulta
				ResultSet rs = null;
				Coche coc;
				Map<String, Coche> coches = new TreeMap<>();

				// Abrimos la conexión
				this.openConnection();

				try {
					stmt = con.prepareStatement(OBTENERcocs);

					rs = stmt.executeQuery();

					// Leemos de uno en uno los propietarios devueltos en el ResultSet
					while (rs.next()) {
						coc = new Coche();
						coc.setMatricula(rs.getString("matricula"));
						coc.setMarca(rs.getString("marca"));
						coc.setModelo(rs.getString("modelo"));
						coc.setEdad(rs.getInt("edad"));
						coc.setPrecio(rs.getDouble("precio"));
						coc.setIdPropietario(rs.getString("idpropietario"));
						coches.put(coc.getMatricula(), coc);
					}
				} catch (SQLException e) {
					System.out.println("Error de SQL");
					e.printStackTrace();
				} finally {
					// Cerramos ResultSet
					if (rs != null) {
						try {
							rs.close();
						} catch (SQLException ex) {
							System.out.println("Error en cierre del ResultSet");
						}
					}
					try {
						this.closeConnection();
					} catch (SQLException e) {
						System.out.println("Error en el cierre de la BD");
						e.printStackTrace();
					}
				}
				return coches;
	}

	@Override
	public void modificarCoche(Coche coche) {
		// Abrimos la conexión
		this.openConnection();

		// Meto los valores del propietario dentro del stmt:
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(UPDATEcoc);

			stmt.setString(1, coche.getMarca());
			stmt.setString(2, coche.getModelo());
			stmt.setInt(3, coche.getEdad());
			stmt.setDouble(4, coche.getPrecio());
			stmt.setString(5, coche.getIdPropietario());
			stmt.setString(6, coche.getMatricula());

			stmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void eliminarCoche(Coche coche) {
		//
		// Abrimos la conexión
		this.openConnection();

		// Metemos los valores del propietario dentro del stmt:
		try {
			// Preparamos la sentencia stmt con la conexion y sentencia sql correspondiente
			stmt = con.prepareStatement(DELETEcoc);

			stmt.setString(1, coche.getMatricula());

			stmt.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Error en la eliminación SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Coche> listarCochesPropietario(String idPropietario) {
		ArrayList <Coche> coches=new ArrayList<>();
		ResultSet rs = null;
		Coche coc = null;

		// Abrimos la conexión
		this.openConnection();

		try {
			stmt = con.prepareStatement(OBTENERcochesPropietario);

			// Cargamos los parámetros
			stmt.setString(1, idPropietario);

			rs = stmt.executeQuery();

			while (rs.next()) {
				coc = new Coche();
				coc.setMatricula(rs.getString("matricula"));
				coc.setMarca(rs.getString("marca"));
				coc.setModelo(rs.getString("modelo"));
				coc.setEdad(rs.getInt("edad"));
				coc.setPrecio(rs.getDouble("precio"));
				coc.setIdPropietario(idPropietario);
				coches.add(coc);
			} 
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return coches;
	}
}
