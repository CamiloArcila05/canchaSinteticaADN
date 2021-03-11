package com.co.canchasintetica.microservicio.infraestructura.persistencia.mapper;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.ReservaEntity;
import com.co.servicios.arrendamientos.infraestructura.persistencia.mapper.PagoMapper;


public class ReservaMapper {
	
	public ReservaMapper() {
	}
	
	private static final ReservaMapper INSTANCE = new ReservaMapper();

	public static ReservaMapper getInstance() {
		return INSTANCE;
	}
	
	public Reserva toDomain(ReservaEntity reservaEntity) {
		return new Reserva(
				reservaEntity.getId(),
				reservaEntity.getCanchaId().getId(),
				reservaEntity.getNombreSolicita(),
				reservaEntity.getFecha(),
				reservaEntity.getHora(),
				reservaEntity.getEstado(),
				reservaEntity.getValorAbono(),
				reservaEntity.getValorTotal());
	}
	
	public com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity toReservaEntityResponse(ReservaEntity reservEntity) {
		return new com.co.canchasintetica.microservicio.aplicacion.handler.reserva.ReservaEntity(
				reservEntity.getId(),
				reservEntity.getCanchaId().getId(),
				reservEntity.getNombreSolicita(),
				reservEntity.getFecha(),
				reservEntity.getHora(),
				reservEntity.getEstado(),
				reservEntity.getValorAbono(),
				reservEntity.getValorTotal());
	}

	public ReservaEntity toEntity(Reserva reservaDoamin, CanchaEntity canchaEntity) {
		ReservaEntity reservaEntity = new ReservaEntity();
		reservaEntity.setId(reservaDoamin.getId());
		reservaEntity.setNombreSolicita(reservaDoamin.getNombreSolicita());
		reservaEntity.setFecha(reservaDoamin.getFecha());
		reservaEntity.setHora(reservaDoamin.getHora());
		reservaEntity.setValorAbono(reservaDoamin.getValorAbono());
		reservaEntity.setValorTotal(reservaDoamin.getValorTotal());
		reservaEntity.setCanchaId(canchaEntity);
		reservaEntity.setEstado(reservaDoamin.getEstado());
		return reservaEntity;
	}

}
