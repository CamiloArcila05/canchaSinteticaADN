package com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.ReservaEntity;


public interface ReservaRepositoryJpa extends CrudRepository<ReservaEntity, Integer>{
	
	@Query("select r from ReservaEntity r")
	List<ReservaEntity> getAll();
	
	@Query("select r from ReservaEntity r where (select id from CanchaEntity where id = :id_cancha) = :id_cancha "
			+ "and r.fecha = :fecha and r.hora = :hora and r.estado = :estado")
	ReservaEntity getByIdCanchaAndFechaAndHoraAndEstado(
			@Param("id_cancha") int id, @Param("fecha") LocalDate fecha, @Param("hora") String hora, @Param("estado") String estado);
	
	@Query("select r from ReservaEntity r where r.id = :id")
	ReservaEntity getById(@Param("id") int id);

}
