package persona;

import java.util.ArrayList;
import java.util.List;

import sistemaAlquiler.Puntuable;
import sistemaAlquiler.Puntuacion;

public class Persona implements Puntuable{
	private String nombre;
	private String email;
	private int telefono;
	private List<Puntuacion> ranking = new ArrayList<Puntuacion>();
	
	public Persona(String nombre, String email, int telefono) {
		setNombre(nombre);
		setEmail(email);
		setTelefono(telefono);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
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
	
	
}
