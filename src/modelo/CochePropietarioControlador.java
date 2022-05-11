package modelo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import modelo.Propietario;

public interface CochePropietarioControlador {
	
	public Propietario buscarPropietario(String wId);
	
	public void addPropietario(Propietario prop);
	
	public Set<Propietario> listarPropietarios();
	
	public boolean modificarPropietario(Propietario prop);
	
	public void eliminarPropietario(Propietario prop);
	
	
	//Coche
	public Coche buscarCoche(String matricula);
	
	public void altaCoche(Coche coche);
	
	public Map<String, Coche> listarCoches();
	
	public void modificarCoche (Coche coche);
	
	public void eliminarCoche (Coche coche);
	
	//Para conseguir los coches de un propietario
	public ArrayList<Coche> listarCochesPropietario(String idPropietario);
	
	
}
