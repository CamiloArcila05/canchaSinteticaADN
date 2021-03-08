package com.co.canchasintetica.testunitarios.dominio.reserva;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.FinalizarReservaService;

public class FinalizarReservaServiceTest {
	
	
	private ReservaRepository reservaRepository;
	private CanchaRepository canchaRepository;
	private FinalizarReservaService finalizarReservaService;
	
	// Data Reserva Test
	private static final int ID_CANCHA = 3;
	private static final String NOMBRE_SOLICITA = "CAMILO ARCILA";
	private static final String FECHA = "2021-03-10";
	private static final String HORA = "18:00";
	private static final String ESTADO = "ACTIVO";
	private static final int VALOR_ABONO = 10000;
	private static final int VALOR_TOTAL = 0;
	private static final int VALOR_SUCCESS = 50000;
	private static final int VALOR_FAIL = 20000;
	
	// Data Cancha Test
		private static final String NOMBRE_CANCHA = "CANCHA DE PRUEBA";
		private static final String DESCRIPCION_CANCHA = "CANCHA DE PRUEBA";
		private static final String ESTADO_CANCHA = "ACTIVO";
		private static final int VALOR_DIA = 50000;
		private static final int VALOR_NOCHE = 60000;
		
		
	//Mensajes
		private static final String MENSAJE_OK = "La reserva ha sido finalizada";
		private static final String MENSAJE_FAIL = "El valor ingresado es inferior al valor que resta por pago";

	
	
	@BeforeEach
	public void setUp() {
		// arrange
		this.reservaRepository = mock(ReservaRepository.class);
		this.canchaRepository = mock(CanchaRepository.class);
	}

	@Test
	void build() {
		// act
		this.finalizarReservaService = new FinalizarReservaService(reservaRepository, canchaRepository);
		// assert
		assertNotNull(this.canchaRepository);
		assertNotNull(this.finalizarReservaService);
	}
	
	 @Test
	    public void finalizarReservaExitoso() {
	        // Given
	    	
	    	Cancha cancha = crearCanchaBuilder
					(3, NOMBRE_CANCHA, DESCRIPCION_CANCHA, ESTADO_CANCHA, VALOR_DIA, VALOR_NOCHE);
			when(this.canchaRepository.getCanchaById(ID_CANCHA)).thenReturn(cancha);
			
	        Reserva reserva = crearReservaBuilder(1, ID_CANCHA, NOMBRE_SOLICITA,
	        		LocalDate.parse(FECHA), HORA, VALOR_ABONO, VALOR_TOTAL, ESTADO);
	    	when(this.reservaRepository.getReservaById(1)).thenReturn(reserva);
	    	
	    	
	    	this.finalizarReservaService = new FinalizarReservaService(reservaRepository, canchaRepository);
	    	String respuesta = finalizarReservaService.finalizarReserva(1, VALOR_SUCCESS);
	    	
	        // Then
	        Assert.assertEquals(MENSAJE_OK, respuesta);
	    }
	 
	 
	 @Test
	    public void finalizarReservaFail() {
	        // Given
	    	
		 try {
	    	Cancha cancha = crearCanchaBuilder
					(3, NOMBRE_CANCHA, DESCRIPCION_CANCHA, ESTADO_CANCHA, VALOR_DIA, VALOR_NOCHE);
			when(this.canchaRepository.getCanchaById(ID_CANCHA)).thenReturn(cancha);
			
	        Reserva reserva = crearReservaBuilder(1, ID_CANCHA, NOMBRE_SOLICITA,
	        		LocalDate.parse(FECHA), HORA, VALOR_ABONO, VALOR_TOTAL, ESTADO);
	    	when(this.reservaRepository.getReservaById(1)).thenReturn(reserva);
	    	
	    	
	    	this.finalizarReservaService = new FinalizarReservaService(reservaRepository, canchaRepository);
	    	String respuesta = finalizarReservaService.finalizarReserva(1, VALOR_FAIL);
	    	
	        // Then
	        Assert.assertEquals(MENSAJE_OK, respuesta);
	        
		 } catch (Exception e) {
		        Assert.assertEquals(MENSAJE_FAIL, e.getMessage());

		}
	    }
	 
		
		private Reserva crearReservaBuilder(int id, int id_cancha, String nombre_solicita, LocalDate fecha, 
				String hora, int valorAbono, int valorTotal, String estado) {
			return new Reserva(id, id_cancha,nombre_solicita, fecha, hora, estado, valorAbono, valorTotal);
		}
		
		private Cancha crearCanchaBuilder(int id, String nombre, String descripcion, String estado, int valorDia, int valorNoche) {
			return new Cancha(id, nombre, descripcion, estado, valorDia, valorNoche);
		}
	
}
