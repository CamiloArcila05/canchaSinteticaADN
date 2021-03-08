package com.co.canchasintetica.testunitarios.dominio.reserva.databuilder;

import java.time.LocalDate;

import com.co.canchasintetica.microservicio.dominio.entidades.Reserva;


public class ReservaTestDataBuilder {

	
	private static final int ID = 1;
	private static final int ID_CANCHA = 1;
	private static final String NOMBRE_SOLICITA = "CAMILO ARCILA";
	private static final String FECHA = "2021-03-10";
	private static final String HORA = "18:00";
	private static final String ESTADO = "ACTIVO";
	private static final int VALOR_ABONO = 10000;
	private static final int VALOR_TOTAL = 0;
	
	private int id;
	private int canchaId;
	private String nombreSolicita;
	private LocalDate fecha;
	private String hora;
	private String estado;
	private int valorAbono;
	private int valorTotal;
	
	
	public ReservaTestDataBuilder() {
		this.id = ID;
		this.canchaId = ID_CANCHA;
		this.nombreSolicita = NOMBRE_SOLICITA;
		this.fecha = LocalDate.parse(FECHA);
		this.hora = HORA;
		this.estado = ESTADO;
		this.valorAbono = VALOR_ABONO;
		this.valorTotal = VALOR_TOTAL;
	}


	public ReservaTestDataBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public ReservaTestDataBuilder setCanchaId(int canchaId) {
		this.canchaId = canchaId;
		return this;
	}


	public ReservaTestDataBuilder setNombreSolicita(String nombreSolicita) {
		this.nombreSolicita = nombreSolicita;
		return this;
	}

	public ReservaTestDataBuilder setFecha(LocalDate fecha) {
		this.fecha = fecha;
		return this;
	}


	public ReservaTestDataBuilder setHora(String hora) {
		this.hora = hora;
		return this;
	}

	public ReservaTestDataBuilder setEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public ReservaTestDataBuilder setValorAbono(int valorAbono) {
		this.valorAbono = valorAbono;
		return this;
	}

	public ReservaTestDataBuilder setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}
	
	
	public Reserva build() {
		return new Reserva(id, canchaId, nombreSolicita, fecha, hora, estado, valorAbono, valorTotal);
	}
	
}
