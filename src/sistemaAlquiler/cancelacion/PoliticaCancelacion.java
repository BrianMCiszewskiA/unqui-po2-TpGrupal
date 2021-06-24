package sistemaAlquiler.cancelacion;

import inmueble.InmuebleEnAlquiler;

public interface PoliticaCancelacion {
	public double costoCancelacion(InmuebleEnAlquiler inmueble);
}
