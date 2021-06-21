package sistemaAlquiler;

import java.time.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import inmueble.Inmueble;
import inmueble.InmuebleEnAlquiler;
import persona.Persona;

public class Propietario extends Persona implements IUsuario{
	
	private SistemaAlquiler sistemaAlquiler;
	private Set<Inmueble> inmuebles = new HashSet<Inmueble>();
	private Set<InmuebleEnAlquiler> inmueblesEnAlquiler = new HashSet<InmuebleEnAlquiler>();
	/* En lo del inmueble en alquiler podría aplicarse el patrón State, porque el estar en alquiler es un estado, como también podría ser reservado,
	 * alquilado, libre, etc. Hay que ver bien si los atributos fotos, check-in check-out (todos los que tengan que ver con un inmueble
	 * en alquiler) se definen directamente en la clase Inmueble desde un principio o si hay que hacer una nueva instancia de una clase 
	 * InmuebleEnAlquiler en donde recién ahí se incluirían esos atributos, sumado al atributo "Inmueble" el cual tendrá la referencia al 
	 * Inmueble que se puso en alquiler.
	 */

	public Propietario(String nombre, String email, int telefono) {
		super(nombre, email, telefono);
	}
	
	public void agregarInmueble(Inmueble inm) {
		this.inmuebles.add(inm);
	}
	
	public void eliminarInmueble(Inmueble inm) {
		this.inmuebles.remove(inm);
	}
	
	@Override
	public void registrarse(SistemaAlquiler sistema) {
		sistemaAlquiler = sistema;
		sistemaAlquiler.agregarPropietario(this);
		
	}

	@Override
	public void darseDeBaja(SistemaAlquiler sistema) {
		if (sistemaAlquiler == sistema) {
			sistemaAlquiler.eliminarPropietario(this);
			sistemaAlquiler = null;
		}
	}
	
	public void realizarAlta(Inmueble inmueble, Set<String> fotos, LocalDateTime in, LocalDateTime out, Pago pago, double precio) {
		InmuebleEnAlquiler inmAlquiler = new InmuebleEnAlquiler(inmueble, fotos, in, out, pago, precio);
		sistemaAlquiler.publicarInmueble(inmAlquiler);
		this.inmueblesEnAlquiler.add(inmAlquiler);
	}

	@Override
	public List<InmuebleEnAlquiler> buscarAlojamiento(String ciudad, LocalDateTime entrada, LocalDateTime salida,
			int huespedes, double precioMin, double precioMax) {
		// TODO Auto-generated method stub
		return null;
	}
}
