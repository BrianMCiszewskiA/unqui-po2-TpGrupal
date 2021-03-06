package sistemaAlquiler;

import java.time.*;
import java.util.List;

import inmueble.InmuebleEnAlquiler;

public interface IUsuario {
	
	public void registrarse(SistemaAlquiler sistema);
	public void darseDeBaja(SistemaAlquiler sistema);
	public List<InmuebleEnAlquiler> buscarAlojamiento(String ciudad, LocalDateTime entrada, LocalDateTime salida, int huespedes, double precioMin, double precioMax);
	// La ciudad de destino y las fechas de entrada y salida son los ?nicos par?metros obligatorios
}
