package inmueble;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import sistemaAlquiler.Pago;

public class InmuebleEnAlquiler {
	private Inmueble inmueble;
	private Set<String> fotos = new HashSet<String>();
	private LocalTime checkIn;
	private LocalTime checkOut;
	private Pago pago;
	private double precioXDia;

	public InmuebleEnAlquiler(Inmueble inmueble, Set<String> fotos, LocalTime in, LocalTime out, Pago pago,
			double precio) {
		setInmueble(inmueble);
		setFotos(fotos);
		setCheckIn(in);
		setCheckOut(out);
		setPago(pago);
		setPrecioXDia(precio);
	}

	private void setPrecioXDia(double precio) {
		this.precioXDia = precio;		
	}

	private void setPago(Pago pago) {
		this.pago = pago;
	}

	private void setCheckOut(LocalTime out) {
		this.checkOut = out;
	}

	private void setCheckIn(LocalTime in) {
		this.checkIn = in;
	}

	private void setFotos(Set<String> fotos) {
		this.fotos = fotos;
	}

	private void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	

}
