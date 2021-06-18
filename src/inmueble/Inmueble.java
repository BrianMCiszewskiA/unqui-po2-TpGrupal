package inmueble;

import java.util.HashSet;
import java.util.Set;

import sistemaAlquiler.Propietario;

public class Inmueble {
	private Propietario propietario;
	private String tipo;
	private int superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private Set<String> servicios = new HashSet<String>();
	private int capacidad;
	
	public Inmueble(Propietario propietario, String tipo, int superficie, String pais, String ciudad, String direccion, Set<String> servicios, int capacidad) {
		setPropietario(propietario);
		setTipo(tipo);
		setSuperficie(superficie);
		setPais(pais);
		setCiudad(ciudad);
		setDireccion(direccion);
		setServicios(servicios);
		setCapacidad(capacidad);
	}

	private void setPropietario(Propietario propietario) {
		this.propietario = propietario;		
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

	public String getCiudad() {
		return this.ciudad;
	}

	public int getCapacidad() {
		return this.capacidad;
	}
}
