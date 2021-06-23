package sistemaAlquiler;

import java.time.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import inmueble.InmuebleEnAlquiler;

public class SistemaAlquiler {

	private Set<IUsuario> inquilinos = new HashSet<IUsuario>();
	private Set<IUsuario> propietarios = new HashSet<IUsuario>();
	private Set <InmuebleEnAlquiler> inmueblesEnAlquiler = new HashSet <InmuebleEnAlquiler> ();
	
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
	
	public Set<IUsuario> getInquilinos() {
		return this.inquilinos;
	}
	
	public Set<IUsuario> getPropietarios() {
		return this.propietarios;
	}
	
	public void publicarInmueble(InmuebleEnAlquiler inmAlquiler) {
		this.inmueblesEnAlquiler.add(inmAlquiler);		
	}

	public List<InmuebleEnAlquiler> alojamientosDisponibles(String ciudad, LocalDateTime entrada, LocalDateTime salida,
			int huespedes, double precioMin, double precioMax) {
		List<InmuebleEnAlquiler> reqObl = inmueblesEnAlquiler.stream().filter(inm -> requisitosObligatorios(inm, ciudad, entrada, salida)).collect(Collectors.toList());
		List<InmuebleEnAlquiler> reqOpc = reqObl.stream().filter(inm -> requisitosOpcionales(inm, huespedes, precioMin, precioMax)).collect(Collectors.toList());
		return reqOpc;
	}
	
	
    boolean requisitosObligatorios(InmuebleEnAlquiler inmueble, String ciudad, LocalDateTime entrada, LocalDateTime salida) {
        Predicate < InmuebleEnAlquiler > p1 = (InmuebleEnAlquiler inm) -> inm.getCiudad().equals(ciudad);
        Predicate < InmuebleEnAlquiler > p2 = (InmuebleEnAlquiler inm) -> inm.getCheckIn() == entrada;
        Predicate < InmuebleEnAlquiler > p3 = (InmuebleEnAlquiler inm) -> inm.getCheckOut() == salida;
        Predicate < InmuebleEnAlquiler > ptotal = p1.and(p2).and(p3);
        return ptotal.test(inmueble);
    }
    
    boolean requisitosOpcionales(InmuebleEnAlquiler inmueble, int capacidad, double precioMin, double precioMax) {
    	Predicate < InmuebleEnAlquiler > p1 = (InmuebleEnAlquiler inm) -> inm.getHuespedes() == capacidad;
    	Predicate < InmuebleEnAlquiler > p2 = (InmuebleEnAlquiler inm) -> inm.getPrecioXDia() >= precioMin;
    	Predicate < InmuebleEnAlquiler > p3 = (InmuebleEnAlquiler inm) -> inm.getPrecioXDia() <= precioMax;
    	Predicate < InmuebleEnAlquiler > ptotal = p1.or(p2).and(p3);
    	return ptotal.test(inmueble);
    }

	public Set<InmuebleEnAlquiler> getInmueblesEnAlquiler() {
		return this.inmueblesEnAlquiler;
	}

}
