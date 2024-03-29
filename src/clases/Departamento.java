package clases;

/**
 * Clase donde se recojen todos los datos relacionados con un departamento.
 * @author Julen
 *
 */

public class Departamento {

	private String codDepartamento;
	private String nombreDepartamento;
	private boolean activoDepartamento;
	private String[] especialidades = new String[5];

	public Departamento() {
		super();
	}

	public Departamento(String codDepartamento) {
		super();
		this.codDepartamento = codDepartamento;
	}

	public Departamento(String codDepartamento, String nombreDepartamento, boolean activoDepartamento, String[] especialidades) {
		super();
		this.codDepartamento = codDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.activoDepartamento = activoDepartamento;
		this.especialidades = especialidades;
	}

	public Departamento(String codDepartamento, String nombreDepartamento, boolean activoDepartamento) {
		super();
		this.codDepartamento = codDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.activoDepartamento = activoDepartamento;
	}

	public String getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public boolean getActivoDepartamento() {
		return activoDepartamento;
	}

	public void setActivoDepartamento(boolean activoDepartamento) {
		this.activoDepartamento = activoDepartamento;
	}

	public String[] getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(String[] especialidades) {
		this.especialidades = especialidades;
	}
}
