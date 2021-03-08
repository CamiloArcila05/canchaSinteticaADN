package com.co.canchasintetica.testunitarios.dominio.cancha;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.dominio.servicios.cancha.ListarCanchasService;

public class ConsultarCanchasServiceTest {

	
	private CanchaRepository canchaRepository;
	private ListarCanchasService listarCanchasService;
	
	@BeforeEach
	public void setUp() {
		// arrange
		this.canchaRepository = mock(CanchaRepository.class);
	}

	@Test
	void build() {
		// act
		this.listarCanchasService = new ListarCanchasService(canchaRepository);
		// assert
		assertNotNull(this.canchaRepository);
		assertNotNull(this.listarCanchasService);
	}
	
}
