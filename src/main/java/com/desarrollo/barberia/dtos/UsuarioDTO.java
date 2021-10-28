package com.desarrollo.barberia.dtos;

public class UsuarioDTO {

	private Long idusuario;
	private String nombreusuario;	
	private String correousuario;
	private String contrausuario;
	public UsuarioDTO(long idusuario, String nombreusuario, String correousuario, String contrausuario) {
		super();
		this.idusuario = idusuario;
		this.nombreusuario = nombreusuario;
		this.correousuario = correousuario;
		this.contrausuario = contrausuario;
	}
	public long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(long idusuario) {
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
