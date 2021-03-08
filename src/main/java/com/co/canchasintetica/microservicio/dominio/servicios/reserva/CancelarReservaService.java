package com.co.canchasintetica.microservicio.dominio.servicios.reserva;

import org.springframework.stereotype.Service;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;

@Service
public class CancelarReservaService {
	
private ReservaRepository reservaRepository;
	
	public CancelarReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	public String cancelarReserva(int id) {
		Reserva reserva = reservaRepository.getReservaById(id);
		reserva.setEstado("CANCELADA");
		reservaRepository.actualizarReserva(reserva);
		return "La reserva ha sido cancelada";
	}

}
