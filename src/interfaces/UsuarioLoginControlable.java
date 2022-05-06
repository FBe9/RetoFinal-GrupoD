package interfaces;

import clases.Usuario;

public interface UsuarioLoginControlable {
	
	public Usuario loginUsuario(String codigoDelUsuario, String contrasenaDelUsuario);
}
