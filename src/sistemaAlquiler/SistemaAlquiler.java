package sistemaAlquiler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import inmueble.InmuebleEnAlquiler;

public class SistemaAlquiler {

	private Set<IUsuario> inquilinos = new HashSet<IUsuario>();
	private Set<IUsuario> propietarios = new HashSet<IUsuario>();
	private HashMap <Propietario, InmuebleEnAlquiler> inmueblesEnAlquiler = new HashMap <Propietario, InmuebleEnAlquiler> ();
	
	public void agregarInquilino(Inquilino inquilino) {
		this.inquilinos.add(inquilino);
		
	}

	public void eliminarInquilino(Inquilino inquilino) {
		this.inquilinos.remove(inquilino);
		
	}

	public void agregarPropietario(Propietario propietario) {
		this.propietarios.add(propietario);
		
	}

	public void eliminarPropietario(Propietario propietario) {
		this.propietarios.remove(propietario);		
	}
	
	public void publicarInmueble(Propietario propietario, InmuebleEnAlquiler inmAlquiler) {
		this.inmueblesEnAlquiler.put(propietario, inmAlquiler);		
	}

}
