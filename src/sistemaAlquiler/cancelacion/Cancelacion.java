package sistemaAlquiler.cancelacion;

import java.time.*;

import inmueble.InmuebleEnAlquiler;

public class Cancelacion implements PoliticaCancelacion{
	private int cantDiasGratis = 10;

	@Override
	public double costoCancelacion(InmuebleEnAlquiler inmueble) {
		// Es gratuito hasta 10 dias antes del inicio de la ocupacion, 
		//	y despues sale el equivalente a 2 dias de reserva.
		if(this.estaDentroDeLosDias(inmueble)) {
			return 0;
		}
		else {
			return inmueble.getPrecioXDia() * 2;
		}
		
	}
	
	private boolean estaDentroDeLosDias(InmuebleEnAlquiler inmueble) {
		LocalDateTime diaInicio = inmueble.getCheckIn().minusDays(this.cantDiasGratis);
		LocalDateTime diaActual = LocalDateTime.now();
		return !diaActual.isAfter(diaInicio);
	}
	

}
