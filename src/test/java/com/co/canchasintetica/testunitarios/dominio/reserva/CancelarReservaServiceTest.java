package com.co.canchasintetica.testunitarios.dominio.reserva;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.CancelarReservaService;

public class CancelarReservaServiceTest {
	
	
	private ReservaRepository reservaRepository;
	private CancelarReservaService cancelarReservaService;
	
	// Data Reserva Test
	private static final int ID_CANCHA = 3;
	private static final String NOMBRE_SOLICITA = "CAMILO ARCILA";
	private static final String FECHA = "2021-03-10";
	private static final String HORA = "18:00";
	private static final String ESTADO = "ACTIVO";
	private static final int VALOR_ABONO = 10000;
	private static final int VALOR_TOTAL = 0;
	
	
	//Mensajes
		private static final String MENSAJE_OK = "La reserva ha sido cancelada";

	
	
	@BeforeEach
	public void setUp() {
		// arrange
		this.reservaRepository = mock(ReservaRepository.class);
	}

	@Test
	void build() {
		// act
		this.cancelarReservaService = new CancelarReservaService(reservaRepository);
		// assert
		assertNotNull(this.cancelarReservaService);
	}
	
	 @Test
	    public void finalizarReservaExitoso() {
	        // Given
	    	
			
	        Reserva reserva = crearReservaBuilder(1, ID_CANCHA, NOMBRE_SOLICITA,
	        		LocalDate.parse(FECHA), HORA, VALOR_ABONO, VALOR_TOTAL, ESTADO);
	    	when(this.reservaRepository.getReservaById(1)).thenReturn(reserva);
	    	
	    	
	    	this.cancelarReservaService = new CancelarReservaService(reservaRepository);
	    	String respuesta = cancelarReservaService.cancelarReserva(1);
	    	
	        // Then
	        Assert.assertEquals(MENSAJE_OK, respuesta);
	    }
	 
	 
		
		private Reserva crearReservaBuilder(int id, int id_cancha, String nombre_solicita, LocalDate fecha, 
				String hora, int valorAbono, int valorTotal, String estado) {
			return new Reserva(id, id_cancha,nombre_solicita, fecha, hora, estado, valorAbono, valorTotal);
		}
	

}
