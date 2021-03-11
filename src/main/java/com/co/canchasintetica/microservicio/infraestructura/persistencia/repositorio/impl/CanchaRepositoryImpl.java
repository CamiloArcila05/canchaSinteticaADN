package com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.CanchaEntity;
import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;
import com.co.canchasintetica.microservicio.dominio.repositorio.CanchaRepository;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.mapper.CanchaMapper;
import com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.jpa.CanchaRepositoryJpa;

@Component
public class CanchaRepositoryImpl implements CanchaRepository {

	@Autowired
	private CanchaRepositoryJpa canchaRepositoryJpa;

	private static final CanchaMapper canchaMapper = CanchaMapper.getInstance();
	
	@Override
	public Cancha crearCancha(Cancha cancha) {
		CanchaEntity entity = canchaMapper.toEntity(cancha);
		return canchaMapper.toDomain(canchaRepositoryJpa.save(entity)); 
	}

	@Override
	public void actualizarCancha(Cancha cancha) {
		CanchaEntity entity = canchaMapper.toEntity(cancha);
		canchaRepositoryJpa.save(entity);
	}

	@Override
	public List<com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity> listarCanchas() {
		return canchaRepositoryJpa.listarCanchas();
	}

	@Override
	public Cancha getCanchaById(int canchaId) {
		CanchaEntity entity = canchaRepositoryJpa.getById(canchaId);
		return canchaMapper.toDomain(entity);
	}


}
