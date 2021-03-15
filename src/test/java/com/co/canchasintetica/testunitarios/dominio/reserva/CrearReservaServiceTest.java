package com.co.canchasintetica.testunitarios.dominio.reserva;

import static org.junit.Assert.assertEquals;
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
import com.co.canchasintetica.microservicio.dominio.servicios.reserva.CrearReservaService;

public class CrearReservaServiceTest {
	
	
	private ReservaRepository reservaRepository;
	private CanchaRepository canchaRepository;
	private CrearReservaService crearReservaService;
	
	// Data Reserva Test
	private static final int ID_CANCHA = 3;
	private static final String NOMBRE_SOLICITA = "CAMILO ARCILA";
	private static final String FECHA = "2021-03-10";
	private static final String HORA = "18:00";
	private static final String ESTADO = "ACTIVO";
	private static final int VALOR_ABONO_SUCCES = 10000;
	private static final int VALOR_ABONO_FAIL = 3000;
	private static final int VALOR_TOTAL = 0;
	
	// Data Cancha Test
		private static final String NOMBRE_CANCHA = "CANCHA DE PRUEBA";
		private static final String DESCRIPCION_CANCHA = "CANCHA DE PRUEBA";
		private static final String ESTADO_CANCHA = "ACTIVO";
		private static final int VALOR_DIA = 50000;
		private static final int VALOR_NOCHE = 60000;
		
		
	//Mensajes
		private static final String VALOR_ABONO_MINIMO = "El valor del abono debe superar el 10% del valor de alquier de la cancha";
		private static final String CAMPOS_VACIOS = "Por favor complete todos los datos solicitados";
		private static final String RESERVA_UNICA = "Ya existe una reserva en esa fecha y en esa hora para esta cancha";
	
	
	@BeforeEach
	public void setUp() {
		// arrange
		this.reservaRepository = mock(ReservaRepository.class);
		this.canchaRepository = mock(CanchaRepository.class);
	}

	@Test
	void build() {
	
		this.crearReservaService = new CrearReservaService(reservaRepository, canchaRepository);
	
		assertNotNull(this.canchaRepository);
		assertNotNull(this.crearReservaService);
	}
	

    @Test
    public void crearReservaExitoso() {
  
    	//Cancha cancha = new CanchaTestDataBuilder().build();
    	Cancha cancha = crearCanchaBuilder
				(3, NOMBRE_CANCHA, DESCRIPCION_CANCHA, ESTADO_CANCHA, VALOR_DIA, VALOR_NOCHE);
		when(this.canchaRepository.getCanchaById(ID_CANCHA)).thenReturn(cancha);
		
		 // Reserva reserva = new ReservaTestDataBuilder().build();
        Reserva reserva = crearReservaBuilder(1, ID_CANCHA, NOMBRE_SOLICITA, 
        		LocalDate.parse(FECHA), HORA, VALOR_ABONO_SUCCES, VALOR_TOTAL, ESTADO);

    	when(this.reservaRepository.crearReserva(reserva)).thenReturn(reserva);
    	this.crearReservaService = new CrearReservaService(reservaRepository, canchaRepository);
    	Reserva reservaCreada = crearReservaService.crearReserva(reserva);
        Assert.assertNotNull(reservaCreada);
    }
    
    @Test
    public void crearReservaFailValorAbono() {
      
    	
    	try {
			
    		Cancha cancha = crearCanchaBuilder
    				(3, NOMBRE_CANCHA, DESCRIPCION_CANCHA, ESTADO_CANCHA, VALOR_DIA, VALOR_NOCHE);
    		when(this.canchaRepository.getCanchaById(ID_CANCHA)).thenReturn(cancha);
    		
            Reserva reserva = crearReservaBuilder(1, ID_CANCHA, NOMBRE_SOLICITA,
            		LocalDate.parse(FECHA), HORA, VALOR_ABONO_FAIL, VALOR_TOTAL, ESTADO);

        	when(this.reservaRepository.crearReserva(reserva)).thenReturn(reserva);
        	this.crearReservaService = new CrearReservaService(reservaRepository, canchaRepository);
        	crearReservaService.crearReserva(reserva);
			
		} catch (Exception e) {
			assertEquals(VALOR_ABONO_MINIMO, e.getMessage());
		}
    }
    
    
    @Test
    public void crearReservaFailCamposVacios() {
     
    	
    	try {
		
    		Cancha cancha = crearCanchaBuilder
    				(3, NOMBRE_CANCHA, DESCRIPCION_CANCHA, ESTADO_CANCHA, VALOR_DIA, VALOR_NOCHE);
    		when(this.canchaRepository.getCanchaById(ID_CANCHA)).thenReturn(cancha);
    		
            Reserva reserva = crearReservaBuilder(1, ID_CANCHA, "", LocalDate.parse(FECHA), "",
            		VALOR_ABONO_FAIL, VALOR_TOTAL, ESTADO);

        	when(this.reservaRepository.crearReserva(reserva)).thenReturn(reserva);
        	this.crearReservaService = new CrearReservaService(reservaRepository, canchaRepository);
            crearReservaService.crearReserva(reserva);
			
		} catch (Exception e) {
			assertEquals(CAMPOS_VACIOS, e.getMessage());
		}
    }
    
   
    
    @Test
    public void crearReservaFailReservaDuplicada() {
    	
    	try {
    	Cancha cancha = crearCanchaBuilder
				(3, NOMBRE_CANCHA, DESCRIPCION_CANCHA, ESTADO_CANCHA, VALOR_DIA, VALOR_NOCHE);
		when(this.canchaRepository.getCanchaById(ID_CANCHA)).thenReturn(cancha);
		
        Reserva reserva = crearReservaBuilder(1, ID_CANCHA, NOMBRE_SOLICITA,
        		LocalDate.parse(FECHA), HORA, VALOR_ABONO_SUCCES, VALOR_TOTAL, ESTADO);

    	when(this.reservaRepository.crearReserva(reserva)).thenReturn(reserva);
    	this.crearReservaService = new CrearReservaService(reservaRepository, canchaRepository);
        crearReservaService.crearReserva(reserva);
        crearReservaService.crearReserva(reserva);
        
    } catch (Exception e) {
		assertEquals(RESERVA_UNICA, e.getMessage());
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
