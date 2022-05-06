package clases;
/**
 * 
 * @author Nerea
 *
 */
public class Paciente {

	private String cic;
	private String codEmpleadoDoctor;
	private String codEmpleadoEnfermero;
	private String dniPaciente;
	private String nombrePaciente;
	private String apellidosPaciente;
	private String tlf;
	private String enfermedad;
	private boolean pacienteRecuperado;

	public Paciente(String cic, String codEmpleadoDoctor, String codEmpleadoEnfermero, String dniPaciente,
			String nombrePaciente, String apellidosPaciente, String tlf, String enfermedad,
			boolean pacienteRecuperado) {
		super();
		this.cic = cic;
		this.codEmpleadoDoctor = codEmpleadoDoctor;
		this.codEmpleadoEnfermero = codEmpleadoEnfermero;
		this.dniPaciente = dniPaciente;
		this.nombrePaciente = nombrePaciente;
		this.apellidosPaciente = apellidosPaciente;
		this.tlf = tlf;
		this.enfermedad = enfermedad;
		this.pacienteRecuperado = pacienteRecuperado;
	}

	public Paciente() {
		super();
	}

	public String getCic() {
		return cic;
	}

	public void setCic(String cic) {
		this.cic = cic;
	}

	public String getCodEmpleadoDoctor() {
		return codEmpleadoDoctor;
	}

	public void setCodEmpleadoDoctor(String codEmpleadoDoctor) {
		this.codEmpleadoDoctor = codEmpleadoDoctor;
	}

	public String getCodEmpleadoEnfermero() {
		return codEmpleadoEnfermero;
	}

	public void setCodEmpleadoEnfermero(String codEmpleadoEnfermero) {
		this.codEmpleadoEnfermero = codEmpleadoEnfermero;
	}

	public String getDniPaciente() {
		return dniPaciente;
	}

	public void setDniPaciente(String dniPaciente) {
		this.dniPaciente = dniPaciente;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getApellidosPaciente() {
		return apellidosPaciente;
	}

	public void setApellidosPaciente(String apellidosPaciente) {
		this.apellidosPaciente = apellidosPaciente;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public boolean isPacienteRecuperado() {
		return pacienteRecuperado;
	}

	public void setPacienteRecuperado(boolean pacienteRecuperado) {
		this.pacienteRecuperado = pacienteRecuperado;
	}

}