package com.co.canchasintetica.microservicio.dominio.servicios.cancha;

import java.util.List;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;

@Service
public class ListarCanchasService {
	
	private CanchaRepository canchaRepository;
	
	public ListarCanchasService(CanchaRepository canchaRepository) {
		this.canchaRepository = canchaRepository;
	}
	
	public List<CanchaEntity> listarCanchas() {
		return canchaRepository.listarCanchas();
	}

}
