package inmueble;

import java.util.HashSet;
import java.util.Set;

public class Inmueble {
	private String tipo;
	private int superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private Set<String> servicios = new HashSet<String>();
	private int capacidad;
	
	public Inmueble(String tipo, int superficie, String pais, String ciudad, String direccion, Set<String> servicios, int capacidad) {
		setTipo(tipo);
		setSuperficie(superficie);
		setPais(pais);
		setCiudad(ciudad);
		setDireccion(direccion);
		setServicios(servicios);
		setCapacidad(capacidad);
	}

	private void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	private void setServicios(Set<String> servicios) {
		this.servicios = servicios;
	}

	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	private void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	private void setPais(String pais) {
		this.pais = pais;
	}

	private void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
