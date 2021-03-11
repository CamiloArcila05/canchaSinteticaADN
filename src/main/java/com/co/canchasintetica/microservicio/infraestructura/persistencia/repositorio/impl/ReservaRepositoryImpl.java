package com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.ReservaEntity;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.mapper.ReservaMapper;
import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.dominio.repositorio.ReservaRepository;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.jpa.CanchaRepositoryJpa;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.jpa.ReservaRepositoryJpa;

@Component
public class ReservaRepositoryImpl implements ReservaRepository {

	@Autowired
	private ReservaRepositoryJpa reservaRepositoryJpa;
	
	@Autowired
	private CanchaRepositoryJpa canchaRepositoryJpa;

	private static final ReservaMapper reservaMapper = ReservaMapper.getInstance();
	

	@Override
	public Reserva crearReserva(Reserva reserva) {
		CanchaEntity cancha = canchaRepositoryJpa.getById(reserva.getCanchaId());
		ReservaEntity entity = reservaMapper.toEntity(reserva, cancha);
		return reservaMapper.toDomain(reservaRepositoryJpa.save(entity)); 
	}

	@Override
	public List<com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity> listarReservas() {
		List<ReservaEntity> list = reservaRepositoryJpa.getAll();
		List<com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity> result
		= new ArrayList<com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity>();
		for (ReservaEntity entity: list) {
			result.add(reservaMapper.toReservaEntityResponse(entity));
		}
		return result;
	}

	@Override
	public Reserva getReservaByCanchaIdAndFechaAndHoraAndEstado(int canchaId, LocalDate fecha, String hora,
			String estado) {
		ReservaEntity entity = reservaRepositoryJpa.getByIdCanchaAndFechaAndHoraAndEstado(canchaId, fecha, hora, estado);
		return entity != null ? reservaMapper.toDomain(entity): null;
	}

	@Override
	public void actualizarReserva(Reserva reserva) {
		CanchaEntity cancha = canchaRepositoryJpa.getById(reserva.getCanchaId());
		ReservaEntity entity = reservaMapper.toEntity(reserva, cancha);
		reservaRepositoryJpa.save(entity);
	}

	@Override
	public Reserva getReservaById(int id) {
		ReservaEntity entity = reservaRepositoryJpa.getById(id);
		return 	reservaMapper.toDomain(entity);
	}


}
