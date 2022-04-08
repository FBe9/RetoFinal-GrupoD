package clases;

public class Enfermero extends Empleado{
	
	private String horario;

	public Enfermero(String horario) {
		super();
		this.horario = horario;
	}

	public Enfermero() {
		super();
	}

	public String gethorario() {
		return horario;
	}

	public void sethorario(String horario) {
		this.horario = horario;
	}
}
