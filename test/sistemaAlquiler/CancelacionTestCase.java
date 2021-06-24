package sistemaAlquiler;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import inmueble.InmuebleEnAlquiler;
import sistemaAlquiler.cancelacion.*;

class CancelacionTestCase {
	@Mock
	private InmuebleEnAlquiler inmueble;
	
	private PoliticaCancelacion cancelacion;
	private LocalDateTime hoy;
	
	
	@BeforeEach
	void setUp() throws Exception {
		inmueble = mock(InmuebleEnAlquiler.class);
		hoy = LocalDateTime.now();
		
		when(inmueble.precioFinal()).thenReturn(1500.0);
		when(inmueble.getPrecioXDia()).thenReturn(50.0);
		
	}

	@Test
	void testCancelacionGratis() {
		when(inmueble.getCheckIn()).thenReturn(hoy.plusDays(11));
		cancelacion = new Cancelacion();
		assertEquals(0, cancelacion.costoCancelacion(inmueble));
	}
	
	@Test
	void testCancelacion() {
		when(inmueble.getCheckIn()).thenReturn(hoy.plusDays(5));
		cancelacion = new Cancelacion();
		assertEquals(100.0, cancelacion.costoCancelacion(inmueble));
	}
	
	@Test
	void testSinCancelacion() {
		cancelacion = new SinCancelacion();
		assertEquals(1500.0, cancelacion.costoCancelacion(inmueble));
	}

	@Test
	void testCancelacionIntermediaGratis() {
		when(inmueble.getCheckIn()).thenReturn(hoy.plusDays(21));
		cancelacion = new CancelacionIntermedia();
		assertEquals(0, cancelacion.costoCancelacion(inmueble));
	}
	
	@Test
	void testCancelacionIntermediaMitad() {
		when(inmueble.getCheckIn()).thenReturn(hoy.plusDays(19));
		cancelacion = new CancelacionIntermedia();
		assertEquals(750.0, cancelacion.costoCancelacion(inmueble));
	}
	
	@Test
	void testCancelacionIntermediaMitad2() {
		when(inmueble.getCheckIn()).thenReturn(hoy.plusDays(10));//deberia hacer algo para que tome el dia limite aaa
		cancelacion = new CancelacionIntermedia();
		System.out.println(hoy);
		System.out.println(inmueble.getCheckIn());
		assertEquals(750.0, cancelacion.costoCancelacion(inmueble));
	}
	
	@Test
	void testCancelacionIntermedia() {
		when(inmueble.getCheckIn()).thenReturn(hoy.plusDays(9));
		cancelacion = new CancelacionIntermedia();
		assertEquals(1500.0, cancelacion.costoCancelacion(inmueble));
	}
	
}
