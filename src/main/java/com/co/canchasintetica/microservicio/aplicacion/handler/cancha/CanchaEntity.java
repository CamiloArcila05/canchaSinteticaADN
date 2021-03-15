package com.co.canchasintetica.microservicio.aplicacion.handler.cancha;


public class CanchaEntity {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String estado;
	private Integer valorDia;
	private Integer valorNoche;
	

	public CanchaEntity(Integer id, String nombre, String descripcion, String estado, Integer valorDia, Integer valorNoche) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.valorDia = valorDia;
		this.valorNoche = valorNoche;
	}
	
	public CanchaEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getValorDia() {
		return valorDia;
	}

	public void setValorDia(Integer valorDia) {
		this.valorDia = valorDia;
	}

	public int getValorNoche() {
		return valorNoche;
	}

	public void setValorNoche(Integer valorNoche) {
		this.valorNoche = valorNoche;
	}

	@Override
	public String toString() {
		return "Cancha [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", valorDia=" + valorDia + ", valorNoche=" + valorNoche + "]";
	}

}
