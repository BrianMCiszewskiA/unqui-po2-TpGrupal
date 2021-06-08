package inmueble;

import java.util.Set;

public class Inmueble {
	private String tipo;
	private int superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private Set<String> servicios;
	private int capacidad;
	
	public Inmueble(String tipo, int sup, String pais, String ciudad, String direccion, Set<String> servicios, int capacidad) {
		this.setTipo(tipo);
		this.setSuperficie(sup);
		this.setPais(pais);
		this.setCiudad(ciudad);
		this.setDireccion(direccion);
		this.setServicios(servicios);
		this.setCapacidad(capacidad);
	}

	private void setTipo(String tipo2) {
		tipo = tipo2;
	}

	private void setSuperficie(int sup) {
		superficie = sup;
	}

	private void setPais(String pais2) {
		pais = pais2;
	}

	private void setCiudad(String ciudad2) {
		ciudad = ciudad2;
	}

	private void setDireccion(String direccion2) {
		direccion = direccion2;
	}

	private void setServicios(Set<String> servicios2) {
		servicios = servicios2;
	}

	private void setCapacidad(int capacidad2) {
		capacidad = capacidad2;
	}

}
