package interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Departamento;

public class DepartamentoControlableBDImplementation implements DepartamentoControlable{
	
	private Connection conexion;
	private PreparedStatement psttm;
	
	private void openConnection() {
		try {
			 //String url = "jdbc:mysql://localhost/nombreBaseDatos";
			 String url ="jdbc:mysql://localhost:3306/hospitalbd?serverTimezone=Europe/Madrid&useSSL=false";
			 //con = DriverManager.getConnection(url+"?" +"user=____&password=_____");
			 conexion = DriverManager.getConnection(url,"root" ,"abcd*1234");
			} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			}
	}
	
	private void closeConnection() throws SQLException{
		if (psttm != null) {
			psttm.close();
		}
		if(conexion != null) {
			conexion.close();	
		}
	}

	@Override
	public void añadirDepartamentos(Departamento departamento) {
		
		
	}

	@Override
	public boolean modificarDepartamentos(Departamento departamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarDepartamentos(Departamento departamento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Departamento> listadoDepartamentos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento buscarDepartamento(String codigoDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

}
