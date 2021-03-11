package com.co.canchasintetica.microservicio.dominio.servicios.cancha;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;

@Service
public class CrearCanchaService {
	
	private CanchaRepository canchaRepository;
	
	public CrearCanchaService(CanchaRepository canchaRepository) {
		this.canchaRepository = canchaRepository;
	}
	
	public Cancha craerCancha(Cancha cancha) {
		return canchaRepository.crearCancha(cancha);
	}

}
