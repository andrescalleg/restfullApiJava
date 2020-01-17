package com.andres.restful.model;

import com.andres.restful.entity.Nota;

public class MNota {

	public MNota() {
	}

	public MNota(Nota nota) {
		this.id = nota.getId();
		this.nombre = nota.getNombre();
		this.tituto = nota.getTituto();
		this.contenido = nota.getContenido();
	}

	public MNota(Long id, String nombre, String tituto, String contenido) {
		this.id = id;
		this.nombre = nombre;
		this.tituto = tituto;
		this.contenido = contenido;
	}

	private Long id;

	private String nombre;

	private String tituto;

	private String contenido;


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

}
