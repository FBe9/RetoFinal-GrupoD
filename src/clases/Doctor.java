package clases;
/**
 * 
 * @author Nerea
 *
 */
public class Doctor extends Empleado {

	private String especialidades;

	public Doctor(String especialidades) {
		super();
		this.especialidades = especialidades;
	}

	public Doctor() {
		super();
	}

	
	public String getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

	

}