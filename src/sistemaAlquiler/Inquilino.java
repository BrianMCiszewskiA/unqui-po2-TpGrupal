package sistemaAlquiler;

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
}


