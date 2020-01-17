package com.andres.restful.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "NOTA")
@Entity
public class Nota {

	public Nota() {
	}

	public Nota(Long id, String nombre, String tituto, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.tituto = tituto;
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTituto() {
		return tituto;
	}

	public void setTituto(String tituto) {
		this.tituto = tituto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@GeneratedValue
	@Id
	@Column(name = "ID_NOTA")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "TITULO")
	private String tituto;

	@Column(name = "CONTENIDO")
	private String contenido;
}
