package clases;

import java.time.LocalDate;
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
	private String apellidosEmpleado;
	private boolean activoEmpleado;
	private String codContrato;
	private boolean activoEmpleado;
  
	public Empleado() {
		super();
	}

	public Empleado(String codEmpleado, String codDepartamento, String dniEmpleado, String nombreEmpleado, String apellidosEmpleado, String codContrato, boolean activoEmpleado) {

		super();
		this.codEmpleado = codEmpleado;
		this.codDepartamento = codDepartamento;
		this.dniEmpleado = dniEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidosEmpleado = apellidosEmpleado;
		this.codContrato = codContrato;
		this.activoEmpleado = activoEmpleado;
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

	public String getApellidosEmpleado() {
		return apellidosEmpleado;
	}

	public void setApellidosEmpleado(String apellidosEmpleado) {
		this.apellidosEmpleado = apellidosEmpleado;
	}

	public boolean isActivoEmpleado() {
		return activoEmpleado;
	}

	public void setActivoEmpleado(boolean activoEmpleado) {
		this.activoEmpleado = activoEmpleado;
	}

	public String getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(String codContrato) {
		this.codContrato = codContrato;
	}
}
