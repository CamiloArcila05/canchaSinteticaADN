package com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reserva", schema = "proyectoadn")
public class ReservaEntity {


	@Id
	@Column(name = "id", nullable = false)
	private int id;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cancha")
	private CanchaEntity id_cancha;
	
	@Column(name = "nombre_solicita", nullable = false)
	private String nombre_solicita ;

	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "hora")
	private String hora;
	
	@Column(name = "estado")
	private String estado;

	@Column(name = "valor_abono")
	private int valor_abono;
	
	@Column(name = "valor_total")
	private int valor_total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CanchaEntity getId_cancha() {
		return id_cancha;
	}

	public void setId_cancha(CanchaEntity id_cancha) {
		this.id_cancha = id_cancha;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre_solicita() {
		return nombre_solicita;
	}

	public void setNombre_solicita(String nombre_solicita) {
		this.nombre_solicita = nombre_solicita;
	}

	public int getValor_abono() {
		return valor_abono;
	}

	public void setValor_abono(int valor_abono) {
		this.valor_abono = valor_abono;
	}

	public int getValor_total() {
		return valor_total;
	}

	public void setValor_total(int valor_total) {
		this.valor_total = valor_total;
	}

	

}
