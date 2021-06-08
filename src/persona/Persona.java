package persona;

public class Persona {
	private String nombre;
	private String email;
	private int telefono;
	
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
	
	
	
}
