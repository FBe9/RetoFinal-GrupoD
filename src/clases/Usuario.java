package clases;

public class Usuario {
	
	private String codigoDelUsuario;
	private String contrasenaDelUsuario;
	private String tipoDeUsuario;
	
	
	public Usuario() {
		super();
	}


	public Usuario(String codigoDelUsuario, String contrasenaDelUsuario) {
		super();
		this.codigoDelUsuario = codigoDelUsuario;
		this.contrasenaDelUsuario = contrasenaDelUsuario;
	}


	public String getCodigoDelUsuario() {
		return codigoDelUsuario;
	}


	public void setCodigoDelUsuario(String codigoDelUsuario) {
		this.codigoDelUsuario = codigoDelUsuario;
	}


	public String getContrasenaDelUsuario() {
		return contrasenaDelUsuario;
	}


	public void setContrasenaDelUsuario(String contrasenaDelUsuario) {
		this.contrasenaDelUsuario = contrasenaDelUsuario;
	}

	
	public String getTipoDeUsuario() {
		return tipoDeUsuario;
	}


	public void setTipoDeUsuario(String tipoDeUsuario) {
		this.tipoDeUsuario = tipoDeUsuario;
	}
	
	
	
	
}
