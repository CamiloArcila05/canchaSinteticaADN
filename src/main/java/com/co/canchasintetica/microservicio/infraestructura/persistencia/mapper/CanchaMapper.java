package com.co.canchasintetica.microservicio.infraestructura.persistencia.mapper;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;


public class CanchaMapper {
	
	public CanchaMapper() {
	}

	public static final CanchaMapper INSTANCE = new CanchaMapper();

	public static CanchaMapper getInstance() {
		return INSTANCE;
	}
	
	
	public Cancha toDomain(CanchaEntity entity) {
		return  new Cancha(
				entity.getId(),
				entity.getNombre(),
				entity.getDescripcion(),
				entity.getEstado(),
				entity.getValorDia(),
				entity.getValorNoche());
	}

	public CanchaEntity toEntity(Cancha canchaDomain) {
		CanchaEntity canchaEntity = new CanchaEntity();
		canchaEntity.setId(canchaDomain.getId());
		canchaEntity.setNombre(canchaDomain.getNombre());
		canchaEntity.setDescripcion(canchaDomain.getDescripcion());
		canchaEntity.setValorDia(canchaDomain.getValorDia());
		canchaEntity.setValorNoche(canchaDomain.getValorNoche());
		canchaEntity.setEstado(canchaDomain.getEstado());
		return canchaEntity;
	}

}
