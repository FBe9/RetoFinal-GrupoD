package clases;

public class Empleado {

	private String codEmpleado;
	private String codDepartamento;
	private String dniEmpleado;
	private String nombreEmpleado;
	private String apellidosEmpleado;
	private boolean activoEmpleado;

	public Empleado() {
		super();
	}

	public Empleado(String codEmpleado, String codDepartamento, String dniEmpleado, String nombreEmpleado,
			String apellidosEmpleado, boolean activoEmpleado) {
		super();
		this.codEmpleado = codEmpleado;
		this.codDepartamento = codDepartamento;
		this.dniEmpleado = dniEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidosEmpleado = apellidosEmpleado;
		this.activoEmpleado = activoEmpleado;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getdniEmpleado() {
		return dniEmpleado;
	}

	public void setdniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getnombreEmpleado() {
		return nombreEmpleado;
	}

	public void setnombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getapellidosEmpleado() {
		return apellidosEmpleado;
	}

	public void setapellidosEmpleado(String apellidosEmpleado) {
		this.apellidosEmpleado = apellidosEmpleado;
	}

	public boolean isactivoEmpleado() {
		return activoEmpleado;
	}

	public void setactivoEmpleado(boolean activoEmpleado) {
		this.activoEmpleado = activoEmpleado;
	}

	public String getcodDepartamento() {
		return codDepartamento;
	}

	public void setcodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

}
