package com.co.canchasintetica.microservicio.dominio.repositorio;

import java.time.LocalDate;
import java.util.List;

import com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity;
import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;

public interface ReservaRepository {
	
	/**
	 * Método que registra una nueva reserva en la BD
	 * 
	 * @param Reserva a registrar
	 * @return Reserva  registrada
	 */
	public Reserva crearReserva(Reserva reserva);
	
	
	/**
	 * Método que actualiza una  reserva en la BD
	 * 
	 * @param Reserva a actualizar
	 */
	public void actualizarReserva(Reserva reserva);
	
	
	/**
	 * Método que lista todos las reservas registradas en la BD
	 * @return reservas registradas
	 */
	public List<ReservaEntity> listarReservas();
	
	/**
	 * Metodo que obtiene una reserva en base a un id
	 * @param id
	 * @return reserva
	 */
	public Reserva getReservaById(int reservaId);
	
	
	/**
	 * Método que retorna una reserva en base a un idCancha, fecha, hora y estado
	 * @return Reserva registrada
	 */
	public Reserva getReservaByCanchaIdAndFechaAndHoraAndEstado(
			int canchaId, LocalDate fecha, String hora, String estado);

}
