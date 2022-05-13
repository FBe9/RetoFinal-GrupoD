package clases;

/**
 * 
 * @author Nerea
 *
 */

public class Doctor extends Empleado {

	private String especialidad;

	public Doctor(String especialidad) {
		super();
		this.especialidad = especialidad;
	}

	public Doctor() {
		super();
	}

	
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

}

