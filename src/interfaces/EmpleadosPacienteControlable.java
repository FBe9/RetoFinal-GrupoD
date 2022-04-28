package interfaces;

import java.util.ArrayList;

import clases.Paciente;

public interface EmpleadosPacienteControlable {

	public Paciente buscarPaciente(String wId);

	public void aņadirPaciente(Paciente prop);

	public ArrayList<Paciente> listarPacientes();

	public boolean modificarPaciente(Paciente prop);

	public boolean eliminarPaciente(Paciente prop);
	
	public ArrayList<Paciente> listarPacientesFiltro(String filtro);
	
}
