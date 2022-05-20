package clases;

import java.sql.Date;
/**
 * 
 * @author Nerea
 *
 */
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

	
	public Contrato(String codContrato, String tipoContrato, Date date, Date date2) {
		super();
		this.codContrato = codContrato;
		this.tipoContrato = tipoContrato;
		this.fechaInicio = date;
		this.fechaFin =  date2;
	}
	
	
}
