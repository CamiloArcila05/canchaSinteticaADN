package com.co.canchasintetica.microservicio.dominio.servicios.reserva;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;

@Service
public class CancelarReservaService {
	
	private static final String ESTADO_CANCALADA = "CANCELADA";
	
private ReservaRepository reservaRepository;
	
	public CancelarReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	public void cancelarReserva(int reservaId) {
		Reserva reservaCancelar = reservaRepository.getReservaById(reservaId);
		reservaCancelar.setEstado(ESTADO_CANCALADA);
		reservaRepository.actualizarReserva(reservaCancelar);
	}

}
