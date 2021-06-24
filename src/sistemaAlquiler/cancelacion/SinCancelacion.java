package sistemaAlquiler.cancelacion;

import inmueble.InmuebleEnAlquiler;

public class SinCancelacion implements PoliticaCancelacion{

	@Override
	public double costoCancelacion(InmuebleEnAlquiler inmueble) {
		// se paga todo igual
		return inmueble.precioFinal();
	}

}
