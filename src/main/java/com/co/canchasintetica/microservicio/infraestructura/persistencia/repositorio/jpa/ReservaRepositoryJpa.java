package com.co.canchasintetica.microservicio.infraestructura.persistencia.repositorio.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades.ReservaEntity;


public interface ReservaRepositoryJpa extends CrudRepository<ReservaEntity, Integer>{
	
	@Query("select reserva from ReservaEntity reserva")
	List<ReservaEntity> getAll();
	
	@Query("select reserva from ReservaEntity reserva where (select id from CanchaEntity where id = :canchaId) = :canchaId "
			+ "and reserva.fecha = :fecha and reserva.hora = :hora and reserva.estado = :estado")
	ReservaEntity getByIdCanchaAndFechaAndHoraAndEstado(
			@Param("canchaId") int canchaId, @Param("fecha") LocalDate fecha, @Param("hora") String hora, @Param("estado") String estado);
	
	@Query("select reserva from ReservaEntity reserva where reserva.id = :id")
	ReservaEntity getById(@Param("id") int id);

}
