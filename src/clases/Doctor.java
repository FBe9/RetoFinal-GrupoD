package clases;

public class Doctor extends Empleado {

	private String especialidades;

	public Doctor(String especialidades) {
		super();
		this.especialidades = especialidades;
	}

	public Doctor() {
		super();
	}

	public String getespecialidades() {
		return especialidades;
	}

	public void setespecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

}
