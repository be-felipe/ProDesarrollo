package com.example.jpa.entity.complex.autor;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Basic
	private String correo;
	
	@Basic
	private String nombre;
	
	@OneToMany(fetch =  FetchType.LAZY, mappedBy = "autor")
	private List<MensajeEntity> mensajes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MensajeEntity> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeEntity> mensajes) {
		this.mensajes = mensajes;
	}
	
}
