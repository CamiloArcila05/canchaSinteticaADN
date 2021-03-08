package com.co.canchasintetica.microservicio.dominio.servicios.reserva;

import java.util.List;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;

@Service
public class ListarReservaService {
	
private ReservaRepository reservaRepository;
	
	public ListarReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	public List<ReservaEntity> listarReservas() {
		return reservaRepository.listarReservas();
	}
}
