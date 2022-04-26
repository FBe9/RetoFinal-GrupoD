package interfaces;

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

import clases.Paciente;

public class EmpleadoPacineteControlableBDImplementation implements EmpleadosPacienteControlable{

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
	
    final String altaPaciente = "INSERT INTO patient(cic, codEmployeeDoctor, codEmployeeNurse, dniPatient, namePatient, lastNamePatient1, lastNamePatient2, tlf, disease, recoverPatient) "
    		+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
    
    
	@Override
	public Paciente buscarPaciente(String wId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPaciente(Paciente prop) {
		// TODO Auto-generated method stub
		
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
