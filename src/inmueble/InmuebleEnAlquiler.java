package inmueble;

import java.time.*;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import sistemaAlquiler.Inquilino;
import sistemaAlquiler.Pago;
import sistemaAlquiler.Propietario;
import sistemaAlquiler.Puntuable;
import sistemaAlquiler.Puntuacion;
import sistemaAlquiler.SistemaAlquiler;

public class InmuebleEnAlquiler{
	private Inmueble inmueble;
	private Set<String> fotos = new HashSet<String>();
	private LocalDateTime checkIn;
	private LocalDateTime checkOut;
	private Pago pago;
	private double precioXDia;
	private Inquilino inquilinoActual;
	
	public InmuebleEnAlquiler(Inmueble inmueble, Set<String> fotos, LocalDateTime in, LocalDateTime out, Pago pago,
			double precio) {
		setInmueble(inmueble);
		setFotos(fotos);
		setCheckIn(in);
		setCheckOut(out);
		setPago(pago);
		setPrecioXDia(precio);;
	}
	
	private void setPrecioXDia(double precio) {
		this.precioXDia = precio;		
	}

	private void setPago(Pago pago) {
		this.pago = pago;
	}

	private void setCheckOut(LocalDateTime out) {
		this.checkOut = out;
	}

	private void setCheckIn(LocalDateTime in) {
		this.checkIn = in;
	}

	private void setFotos(Set<String> fotos) {
		this.fotos = fotos;
	}

	private void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	
	
	
	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public LocalDateTime getCheckIn() {
		return this.checkIn;
	}

	public LocalDateTime getCheckOut() {
		return this.checkOut;
	}

	public String getCiudad() {
		return inmueble.getCiudad();
	}

	public int getHuespedes() {
		return inmueble.getCapacidad();
	}
	
	public double getPrecioXDia() {
		return this.precioXDia;
	}
	
	//inquilinos
	public void alquilar(SistemaAlquiler sistema, Inquilino inq) {
			inquilinoActual = inq;
			sistema.marcarComoAlquilado(this);
	}
	public void realizarCheckOut(SistemaAlquiler sistema, Inquilino inq) {
		inquilinoActual = null;
		sistema.checkOutAlquiler(this);
		//agregar algo para permitir que el propietario pueda puntear al inquilino
	}
	
	//puntuacion
	public void puntearPropietario(Puntuacion pun) {
		this.getInmueble().puntearPropietario(pun);
	}
	public void puntearInmueble(Puntuacion pun) {
		this.getInmueble().agregarPuntuacion(pun);
	}
}
