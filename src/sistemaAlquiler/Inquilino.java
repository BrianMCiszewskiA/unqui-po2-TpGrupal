package sistemaAlquiler;

import java.time.LocalDate;
import java.util.Set;

import inmueble.InmuebleEnAlquiler;
import persona.Persona;

public class Inquilino extends Persona implements IUsuario{
	
	private SistemaAlquiler sistemaAlquiler;
	
	public Inquilino(String nombre, String email, int telefono) {
		super(nombre, email, telefono);
	}

	@Override
	public void registrarse(SistemaAlquiler sistema) {
		sistemaAlquiler = sistema;
		sistemaAlquiler.agregarInquilino(this);
		
	}

	@Override
	public void darseDeBaja(SistemaAlquiler sistema) {
		if (sistemaAlquiler == sistema) {
			sistemaAlquiler.eliminarInquilino(this);
			sistemaAlquiler = null;
		}
	}

	@Override
	public Set<InmuebleEnAlquiler> buscarAlojamiento(String ciudad, LocalDate entrada, LocalDate salida, int huespedes,
			double precioMin, double precioMax) {
		requisitosMinimos(ciudad, entrada, salida);
		return sistemaAlquiler.alojamientosDisponibles(ciudad, entrada, salida, huespedes, precioMin, precioMax);
	}
	
	private void requisitosMinimos(String ciudad, LocalDate entrada, LocalDate salida) {
		if (ciudad == null || entrada == null || salida == null) {
			throw new RuntimeException("La ciudad, la fecha de entrada y la de salida, no pueden ser nulas");
		}
	}
}


