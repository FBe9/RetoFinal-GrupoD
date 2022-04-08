package clases;

public class Departamento {

	private String codDepartamento;
	private String nombreDepartamento;
	private boolean activoDepartamento;
	private String[] especialidades = new String[5];

	public Departamento() {
		super();
	}

	public Departamento(String codDepartamento, String nombreDepartamento, boolean activoDepartamento, String[] especialidades) {
		super();
		this.codDepartamento = codDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.activoDepartamento = activoDepartamento;
		this.especialidades = especialidades;
	}

	public String getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getnombreDepartamento() {
		return nombreDepartamento;
	}

	public void setnombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public boolean isactivoDepartamento() {
		return activoDepartamento;
	}

	public void setactivoDepartamento(boolean activoDepartamento) {
		this.activoDepartamento = activoDepartamento;
	}

	public String[] getespecialidades() {
		return especialidades;
	}

	public void setespecialidades(String[] especialidades) {
		this.especialidades = especialidades;
	}

}
