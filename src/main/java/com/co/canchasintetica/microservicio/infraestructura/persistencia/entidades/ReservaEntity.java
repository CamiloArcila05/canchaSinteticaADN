package com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_cancha")
	private CanchaEntity canchaId;
	
	@Column(name = "nombre_solicita", nullable = false)
	private String nombreSolicita ;

	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "hora")
	private String hora;
	
	@Column(name = "estado")
	private String estado;

	@Column(name = "valor_abono")
	private Integer valorAbono;
	
	@Column(name = "valor_total")
	private Integer valorTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public CanchaEntity getCanchaId() {
		return canchaId;
	}

	public void setCanchaId(CanchaEntity canchaId) {
		this.canchaId = canchaId;
	}

	public String getNombreSolicita() {
		return nombreSolicita;
	}

	public void setNombreSolicita(String nombreSolicita) {
		this.nombreSolicita = nombreSolicita;
	}

	public Integer getValorAbono() {
		return valorAbono;
	}

	public void setValorAbono(Integer valorAbono) {
		this.valorAbono = valorAbono;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	
}
