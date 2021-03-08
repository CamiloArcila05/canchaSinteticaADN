package com.co.canchasintetica.testintegracion.infraestructura.cancha.databuilder;

import com.co.canchasintetica.microservicio.aplicacion.handler.cancha.CanchaEntity;

public class CanchaControloadorTestDataBuilder {
	
	 public static final int ID = 1;
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
	
	
	public CanchaControloadorTestDataBuilder() {
		this.id = ID;
		this.nombre = NOMBRE;
		this.descripcion = DESCRIPCION;
		this.estado = ESTADO;
		this.valorDia = VALOR_DIA;
		this.valorNoche = VALOR_NOCHE;
	}


	public CanchaControloadorTestDataBuilder setId(int id) {
		this.id = id;
		return this;
	}


	public CanchaControloadorTestDataBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}


	public CanchaControloadorTestDataBuilder setDescripcion(String descripcion) {
		this.descripcion = descripcion;
		return this;
	}


	public CanchaControloadorTestDataBuilder setEstado(String estado) {
		this.estado = estado;
		return this;
	}



	public CanchaControloadorTestDataBuilder setValorDia(int valorDia) {
		this.valorDia = valorDia;
		return this;
	}



	public CanchaControloadorTestDataBuilder setValorNoche(int valorNoche) {
		this.valorNoche = valorNoche;
		return this;
	}
	
	
    public CanchaEntity build(){
	        return new CanchaEntity(id, nombre, descripcion, estado, valorDia, valorNoche);
	 }

}
