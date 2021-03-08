package com.co.canchasintetica.microservicio.dominio.servicios.cancha;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;

@Service
public class ActualizarCanchaService {
	
	private CanchaRepository canchaRepository;
	
	public ActualizarCanchaService(CanchaRepository canchaRepository) {
		this.canchaRepository = canchaRepository;
	}
	
	public void actualizarCancha(Cancha cancha) {
		canchaRepository.actualizarCancha(cancha);
	}

}
