package inmueble;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import sistemaAlquiler.Pago;
import sistemaAlquiler.Puntuable;
import sistemaAlquiler.Puntuacion;

public class InmuebleEnAlquiler implements Puntuable{
	private List<Puntuacion> ranking = new ArrayList<Puntuacion>();

	public InmuebleEnAlquiler(Inmueble inmueble, Set<String> fotos, LocalTime in, LocalTime out, Set<Pago> pagos,
			double precio) {
		// TODO Auto-generated constructor stub
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
