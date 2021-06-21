package sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SistemaAlquilerTest {
	SistemaAlquiler sistema; //SUT
	@Mock Inquilino inquilino;
	@Mock Propietario propietario;

	@BeforeEach
	void setUp() throws Exception {
		sistema = new SistemaAlquiler();
		inquilino = mock(Inquilino.class);
		propietario = mock(Propietario.class);
		
		when(inquilino.getNombre()).thenReturn("Leonel");
		when(inquilino.getEmail()).thenReturn("leonel@hotmail.com");
		when(inquilino.getTelefono()).thenReturn(1150625347);
		
	}

	@Test
	void agregarInquilinoTest() {		
		sistema.agregarInquilino(inquilino);
		assertEquals(1, sistema.getInquilinos().size());
	}

}
