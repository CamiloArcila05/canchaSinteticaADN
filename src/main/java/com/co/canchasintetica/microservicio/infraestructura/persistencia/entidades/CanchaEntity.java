package com.co.canchasintetica.microservicio.infraestructura.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "cancha", schema = "proyectoadn")
public class CanchaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private String estado;

	@Column(name = "valor_dia")
	private Integer valorDia;
	
	@Column(name = "valor_noche")
	private Integer valorNoche;

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

	public Integer getValorDia() {
		return valorDia;
	}

	public void setValorDia(Integer valorDia) {
		this.valorDia = valorDia;
	}

	public Integer getValorNoche() {
		return valorNoche;
	}

	public void setValorNoche(Integer valorNoche) {
		this.valorNoche = valorNoche;
	}
	
	

}
