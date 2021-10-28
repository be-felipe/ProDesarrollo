package com.desarrollo.barberia.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idreserva;
	
	private String nombrereserva;
	
	Date  dia;
	@ManyToOne
	private Barberia barberia;
	@ManyToOne
	private Cliente cliente;
	
	private boolean Asistio;
	
	public Reserva() {
		
	}
	
	public Reserva(Long idreserva, String nombrereserva, Date dia, Barberia barberia, Cliente cliente,
			boolean asistio) {
		super();
		this.idreserva = idreserva;
		this.nombrereserva = nombrereserva;
		this.dia = dia;
		this.barberia = barberia;
		this.cliente = cliente;
		Asistio = asistio;
	}
	
	
	public boolean isAsistio() {
		return Asistio;
	}


	public void setAsistio(boolean asistio) {
		Asistio = asistio;
	}
	


	public Barberia getBarberia() {
		return barberia;
	}

	public void setBarberia(Barberia barberia) {
		this.barberia = barberia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
}