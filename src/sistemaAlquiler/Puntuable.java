package sistemaAlquiler;

import java.util.ArrayList;
import java.util.List;

public interface Puntuable {
	//usar una variable tipo ArrayList<Puntuacion> (no declarar aca)
	int puntuacion(); //devuelve la puntuacion final en base a un promedio del ranking
	void agregarPuntuacion(Puntuacion puntuacion);
}
