package inmueble;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sistemaAlquiler.Propietario;
import sistemaAlquiler.Puntuable;
import sistemaAlquiler.Puntuacion;

public class Inmueble implements Puntuable{
	private List<Puntuacion> ranking = new ArrayList<Puntuacion>();
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
	
	public Propietario getPropietario() {
		return this.propietario;
	}
	
	@Override
	public int puntuacion() {
		int count = 0;
		for(Puntuacion puntuacion: ranking) {
			count = count + puntuacion.valor();
		}
		return count/ranking.size();
	}

	@Override
	public void agregarPuntuacion(Puntuacion puntuacion) {
		ranking.add(puntuacion);
	}
	
	public void puntearPropietario(Puntuacion puntuacion) {
		this.getPropietario().agregarPuntuacion(puntuacion);
	}

}
