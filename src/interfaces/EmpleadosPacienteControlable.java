package interfaces;

import java.util.ArrayList;

import clases.Paciente;

public interface EmpleadosPacienteControlable {

	public Paciente buscarPaciente(String wCIC);

	public void añadirPaciente(Paciente pac);

	public ArrayList<Paciente> listarPacientes(String codEmple);

	public boolean modificarPaciente(Paciente pac, String wCIC);

	public boolean eliminarPaciente(String wCIC);
	
	public ArrayList<Paciente> listarPacientesFiltro(String filtro, String codEmple);
	
}
