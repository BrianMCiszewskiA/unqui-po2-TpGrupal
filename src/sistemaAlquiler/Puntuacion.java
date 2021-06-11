package sistemaAlquiler;

//cree un enum para poder "limitar" la puntuacion
public enum Puntuacion{
	UnaEstrella(1),
	DosEstrellas(2),
	TresEstrellas(3),
	CuatroEstrellas(4),
	CincoEstrellas(5),
	;
	
	private int valor;
	
	Puntuacion(int valor2){
		this.valor = valor2;
	}
	public int valor() {
		return valor;
	}
}
