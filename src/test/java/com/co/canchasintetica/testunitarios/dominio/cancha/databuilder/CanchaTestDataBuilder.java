package com.co.canchasintetica.testunitarios.dominio.cancha.databuilder;

import com.co.canchasintetica.microservicio.dominio.entidades.Cancha;

public class CanchaTestDataBuilder {
	
	
	public static final int ID = 3;
	private static final String NOMBRE = "CANCHA DE PRUEBA";
	private static final String DESCRIPCION = "CANCHA DE PRUEBA";
	private static final String ESTADO = "ACTIVO";
	private static final int VALOR_DIA = 50000;
	private static final int VALOR_NOCHE = 60000;
	
	private int id;
	private String nombre;
	private String descripcion;
	private String estado;
	private int valorDia;
	private int valorNoche;
	
	public CanchaTestDataBuilder() {
		this.id = ID;
		this.nombre = NOMBRE;
		this.descripcion = DESCRIPCION;
		this.estado = ESTADO;
		this.valorDia = VALOR_DIA;
		this.valorNoche = VALOR_NOCHE;
	}

	public CanchaTestDataBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public CanchaTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public CanchaTestDataBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}

	public CanchaTestDataBuilder setEstado(String estado) {
		this.estado = estado;
		return this;
	}

	public CanchaTestDataBuilder setValorDia(int valorDia) {
		this.valorDia = valorDia;
		return this;
	}

	public CanchaTestDataBuilder setValorNoche(int valorNoche) {
		this.valorNoche = valorNoche;
		return this;
	}
	

	 public Cancha build(){
	        return new Cancha(id, nombre, descripcion, estado, valorDia, valorNoche);
	 }
	

}
