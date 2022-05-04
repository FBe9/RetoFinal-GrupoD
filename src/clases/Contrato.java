package clases;

import java.sql.Array;
import java.sql.Date;

public class Contrato {
	private String codContrato;
	private String tipoContrato;
	private Date fechaInicio;
	private Date fechaFin;

	
	
	
	public String getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(String codContrato) {
		this.codContrato = codContrato;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Contrato() {
		super();
	}

	
	
	
	public Contrato(String codContrato, String tipoContrato, Date fechaInicio, Date fechaFin) {
		super();
		this.codContrato = codContrato;
		this.tipoContrato = tipoContrato;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	
}
