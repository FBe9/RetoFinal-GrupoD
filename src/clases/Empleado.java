package clases;

/**
 * 
 * @author Nerea
 *
 */

public class Empleado {

	private String codEmpleado;
	private String codDepartamento;
	private String dniEmpleado;
	private String nombreEmpleado;
	private String apellido1Empleado;
	private String apellido2Empleado;
	private boolean activoEmpleado;
	private String tipoEmpleado;
  
	public Empleado() {
		super();
	}

	public Empleado(String codEmpleado, String codDepartamento, String dniEmpleado, String nombreEmpleado,
			String apellido1Empleado, String apellido2Empleado, boolean activoEmpleado,
			String tipoEmpleado) {
		super();
		this.codEmpleado = codEmpleado;
		this.codDepartamento = codDepartamento;
		this.dniEmpleado = dniEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellido1Empleado = apellido1Empleado;
		this.apellido2Empleado = apellido2Empleado;
		this.activoEmpleado = activoEmpleado;
		this.tipoEmpleado = tipoEmpleado;
	}


	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}


	public String getApellido1Empleado() {
		return apellido1Empleado;
	}


	public void setApellido1Empleado(String apellido1Empleado) {
		this.apellido1Empleado = apellido1Empleado;
	}


	public String getApellido2Empleado() {
		return apellido2Empleado;
	}


	public void setApellido2Empleado(String apellido2Empleado) {
		this.apellido2Empleado = apellido2Empleado;
	}


	public boolean isActivoEmpleado() {
		return activoEmpleado;
	}

	public void setActivoEmpleado(boolean activoEmpleado) {
		this.activoEmpleado = activoEmpleado;
	}

	public String getTipoEmpleado() {
		return tipoEmpleado;
	}


	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
}
