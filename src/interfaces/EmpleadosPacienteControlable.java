package interfaces;

import java.util.ArrayList;

import clases.Paciente;

public interface EmpleadosPacienteControlable {

	public Paciente buscarPaciente(String wId);

	public void aņadirPaciente(Paciente pac);

	public ArrayList<Paciente> listarPacientes();

	public boolean modificarPaciente(Paciente pac);

	public boolean eliminarPaciente(Paciente pac);
	
	public ArrayList<Paciente> listarPacientesFiltro(String filtro);
	
}
