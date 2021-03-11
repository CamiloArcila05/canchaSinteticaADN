package com.co.canchasintetica.testunitarios.dominio.cancha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.dominio.servicios.cancha.CrearCanchaService;
import com.co.canchasintetica.testunitarios.dominio.cancha.databuilder.CanchaTestDataBuilder;

public class CrearCanchaServiceTest {

	private CanchaRepository canchaRepository;
	private CrearCanchaService crearCanchaService;
	
	//
	private static final String CAMPOS_VACIOS = "Por favor complete todos los datos solicitados";
	
	

	@BeforeEach
	public void setUp() {
		// arrange
		this.canchaRepository = mock(CanchaRepository.class);
	}

	@Test
	void build() {
		// act
		this.crearCanchaService = new CrearCanchaService(canchaRepository);
		// assert
		assertNotNull(this.canchaRepository);
		assertNotNull(this.crearCanchaService);
	}
	
	@Test
	void crearCanchaExitosoTest() throws Exception {
		// arrange
		Cancha cancha = new CanchaTestDataBuilder().build();
		when(this.canchaRepository.crearCancha(cancha)).thenReturn(cancha);
		this.crearCanchaService = new CrearCanchaService(canchaRepository);

		// act
		Cancha canchaCreada = this.crearCanchaService.craerCancha(cancha);

		// assert
		Assert.assertNotNull(canchaCreada);

	}
	
	
	@Test
	void crearCanchaFailTest() throws Exception {
		// arrange
	
		try {
			// arrange
			Cancha cancha = new CanchaTestDataBuilder().build();
			cancha.setNombre("");
			when(this.canchaRepository.crearCancha(cancha)).thenReturn(cancha);
			this.crearCanchaService = new CrearCanchaService(canchaRepository);
		    this.crearCanchaService.craerCancha(cancha);
			
		} catch (Exception e) {
			assertEquals(CAMPOS_VACIOS, e.getMessage());
		}

	}
	
}
