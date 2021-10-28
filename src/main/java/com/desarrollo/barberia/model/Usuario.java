package com.desarrollo.barberia.model;

import javax.management.relation.Role;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idusuario;
	
	private String nombreusuario;
	
	private String correousuario;
  private  Role rol;
	private String contrausuario;
	public Usuario(Long idusuario2, String nombreusuario, String correousuario, String contrausuario) {
		super();
		this.idusuario = idusuario2;
		this.nombreusuario = nombreusuario;
		this.correousuario = correousuario;
		this.contrausuario = contrausuario;
	}
	
	public Usuario() {
		super();
	}

	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombreusuario() {
		return nombreusuario;
	}
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	public String getCorreousuario() {
		return correousuario;
	}
	public void setCorreousuario(String correousuario) {
		this.correousuario = correousuario;
	}
	public String getContrausuario() {
		return contrausuario;
	}
	public void setContrausuario(String contrausuario) {
		this.contrausuario = contrausuario;
	}
	
}