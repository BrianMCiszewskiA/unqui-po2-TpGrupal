package sistemaAlquiler.cancelacion;

import java.time.LocalDateTime;

import inmueble.InmuebleEnAlquiler;

public class CancelacionIntermedia implements PoliticaCancelacion{
	int cantDiasPreviosGratuita = 20;
	int cantDiasPreviosMitad = 10;
	@Override
	public double costoCancelacion(InmuebleEnAlquiler inmueble) {
		//si cancela antes de 20 dias es gratis, si cancela entre 19 y 10 dias
		//	solo paga la mitad, y sino, la totalidad
		if(estaDentroDeLosDias(inmueble, this.cantDiasPreviosGratuita)) {
			return 0;
		} else if (this.estaDentroDeLosDias(inmueble, this.cantDiasPreviosMitad)) {
			return inmueble.precioFinal() % 2;
		} else {
			return inmueble.precioFinal();
		}
	}
	
	private boolean estaDentroDeLosDias(InmuebleEnAlquiler inmueble, int dias) {
		LocalDateTime diaInicio = inmueble.getCheckIn().minusDays(dias);
		LocalDateTime diaActual = LocalDateTime.now();
		return !diaActual.isAfter(diaInicio);
	}
}
