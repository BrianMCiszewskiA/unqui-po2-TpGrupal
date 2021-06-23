package sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import inmueble.InmuebleEnAlquiler;

class SistemaAlquilerTest {
	private SistemaAlquiler sistema; //SUT

	@Mock
	// DUMMYS
	private Inquilino inquilino;
	private Propietario propietario;
	private InmuebleEnAlquiler inmueble;


	@BeforeEach	
	void setUp() throws Exception {
		
		sistema = new SistemaAlquiler();
		inquilino = mock(Inquilino.class);
		propietario = mock(Propietario.class);
		inmueble = mock(InmuebleEnAlquiler.class);
		
		/*
		when(inquilino.getNombre()).thenReturn("Leonel");
		when(inquilino.getEmail()).thenReturn("leonel@hotmail.com");
		when(inquilino.getTelefono()).thenReturn(1150625347);
		*/
		
		when(inmueble.getCiudad()).thenReturn("Quilmes");
		when(inmueble.getCheckIn()).thenReturn(LocalDateTime.of(2021, 10, 20, 8, 30));
		when(inmueble.getCheckOut()).thenReturn(LocalDateTime.of(2021, 10, 27, 20, 00));
		when(inmueble.getHuespedes()).thenReturn(1);
		when(inmueble.getPrecioXDia()).thenReturn(1500.00);
	}

	@Test
	void agregarInquilinoTest() {		
		sistema.agregarInquilino(inquilino);
		assertEquals(1, sistema.getInquilinos().size());
	}
	
	@Test
	void noAgregarInquilinoRepetidoTest() {		
		sistema.agregarInquilino(inquilino);
		sistema.agregarInquilino(inquilino);
		assertEquals(1, sistema.getInquilinos().size());
	}
	
	@Test
	void removerInquilinoTest() {		
		sistema.agregarInquilino(inquilino);
		sistema.eliminarInquilino(inquilino);
		assertEquals(0, sistema.getInquilinos().size());
	}
	
	@Test
	void agregarPropietarioTest() {		
		sistema.agregarPropietario(propietario);
		assertEquals(1, sistema.getPropietarios().size());
	}
	
	@Test
	void removerPropietarioTest() {		
		sistema.agregarPropietario(propietario);
		sistema.eliminarPropietario(propietario);
		assertEquals(0, sistema.getPropietarios().size());
	}
	
	@Test
	void noAgregarPropietarioRepetidoTest() {		
		sistema.agregarPropietario(propietario);
		sistema.agregarPropietario(propietario);
		assertEquals(1, sistema.getPropietarios().size());
	}
	
	@Test
	void publicarInmuebleTest() {
		sistema.publicarInmueble(inmueble);
		assertEquals(1, sistema.getInmueblesEnAlquiler().size());
	}
	
	@Test
	void noAgregarInmuebleRepetidoTest() {		
		sistema.publicarInmueble(inmueble);
		sistema.publicarInmueble(inmueble);
		assertEquals(1, sistema.getInmueblesEnAlquiler().size());
	}
	
	@Test
	void requisitosObligatoriosTest() {
		boolean cumple = sistema.requisitosObligatorios(inmueble, "Quilmes", LocalDateTime.of(2021, 10, 20, 8, 30), LocalDateTime.of(2021, 10, 27, 20, 00));
		assertTrue(cumple);
	}
	/*
	@Test
	void inmuebleConRequisitosCoincidentes() {
		sistema.publicarInmueble(inmueble);
		List<InmuebleEnAlquiler> lista = sistema.alojamientosDisponibles("Quilmes", LocalDateTime.of(2021, 10, 20, 8, 30), LocalDateTime.of(2021, 10, 27, 20, 00), 1, 1300, 1800);
		assertEquals(1, lista.size());
	}*/

}
