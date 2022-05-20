package clases;

/**
 * Clase que hereda de Empleado donde se recojen todos los datos relacionados con un Enfermero
 * 
 * @author Nerea
 *
 */

public class Enfermero extends Empleado{
	
	private String horario;

	public Enfermero(String horario) {
		super();
		this.horario = horario;
	}

	public Enfermero() {
		super();
	}

	
	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
}

