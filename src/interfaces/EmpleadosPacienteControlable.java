package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import clases.Paciente;

/**
 * Esta clase controla a la clase que implementa a los pacientes en la base de datos
 * 
 * @author Emil
 *
 */

public interface EmpleadosPacienteControlable {

	/*
	 * Metodos que se usan para paciente
	 */
	public Paciente buscarPaciente(String wCIC);

	public void aniadirPaciente(Paciente pac);

	public ArrayList<Paciente> listarPacientes(String codEmple);

	public boolean modificarPaciente(Paciente pac, String wCIC);

	public boolean eliminarPaciente(String wCIC);

	public ArrayList<String> listaMedicos() ;

	public ArrayList<String> listaEnfermeros();

}
