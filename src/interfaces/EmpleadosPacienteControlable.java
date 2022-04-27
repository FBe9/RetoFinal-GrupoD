package interfaces;

import java.util.ArrayList;

import clases.Paciente;

public interface EmpleadosPacienteControlable {

public Paciente buscarPaciente(String wId);
	
	public void añadirPaciente(Paciente prop);
	
	public ArrayList<Paciente> listarPacientes();
	
	public boolean modificarPaciente(Paciente prop);
	
	public void eliminarPaciente(Paciente prop);
}
