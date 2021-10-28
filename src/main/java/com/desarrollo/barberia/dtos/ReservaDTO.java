package com.desarrollo.barberia.dtos;

import java.util.Date;

public class ReservaDTO {

	private Long idreserva;
	private String nombrereserva;
	private Date dia;
	private String nombarberia;
	private String nomcliente;
	public ReservaDTO(long idreserva, String nombrereserva, Date dia, String nombarberia, String nomcliente) {
		super();
		this.idreserva = idreserva;
		this.nombrereserva = nombrereserva;
		this.dia = dia;
		this.nombarberia = nombarberia;
		this.nomcliente = nomcliente;
		
	}
	public long getIdreserva() {
		return idreserva;
	}
	public void setIdreserva(long idreserva) {
		this.idreserva = idreserva;
	}
	public String getNombrereserva() {
		return nombrereserva;
	}
	public void setNombrereserva(String nombrereserva) {
		this.nombrereserva = nombrereserva;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public String getNombarberia() {
		return nombarberia;
	}
	public void setNombarberia(String nombarberia) {
		this.nombarberia = nombarberia;
	}
	public String getNomcliente() {
		return nomcliente;
	}
	public void setNomcliente(String nomcliente) {
		this.nomcliente = nomcliente;
	}
	
	
}
