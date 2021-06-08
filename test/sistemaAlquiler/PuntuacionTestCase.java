package sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import persona.Persona;

class PuntuacionTestCase {
	private Persona dummy;
	private Puntuacion s1;
	private Puntuacion s2;
	private Puntuacion s3;
	private Puntuacion s4;
	private Puntuacion s5;
	
	@BeforeEach
	void setUp() throws Exception {
		dummy = new Persona("Pepito", "goku@hotmail.com", 1122334455);
		s1 = Puntuacion.UnaEstrella;
		s2 = Puntuacion.DosEstrellas;
		s3 = Puntuacion.TresEstrellas;
		s4 = Puntuacion.CuatroEstrellas;
		s5 = Puntuacion.CincoEstrellas;
		dummy.agregarPuntuacion(s1);
	}

	@Test
	void testPuntuacion1() {
		assertEquals(1, dummy.puntuacion());
	}
	@Test
	void testPuntuacion2() {
		dummy.agregarPuntuacion(s1);
		assertEquals(1, dummy.puntuacion());
	}
	
	@Test
	void testPuntuacion3() {
		dummy.agregarPuntuacion(s5);
		dummy.agregarPuntuacion(s3);
		dummy.agregarPuntuacion(s2);
		dummy.agregarPuntuacion(s4);
		assertEquals(3, dummy.puntuacion());
	}

}
