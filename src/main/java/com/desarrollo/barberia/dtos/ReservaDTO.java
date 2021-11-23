package com.desarrollo.barberia.dtos;

import java.util.Date;

import com.desarrollo.barberia.model.Barberia;
import com.desarrollo.barberia.model.Cliente;

public class ReservaDTO {

	private Long idreserva;
	private String nombrereserva;
	private Date dia;
	private BarberiaDTO barberia;
	private ClienteDTO cliente;
	
	public ReservaDTO() {
		
		
	}

	public ReservaDTO(Long idreserva, String nombrereserva, Date dia, BarberiaDTO barberia, ClienteDTO cliente) {
		super();
		this.idreserva = idreserva;
		this.nombrereserva = nombrereserva;
		this.dia = dia;
		this.barberia = barberia;
		this.cliente = cliente;
	}

	public Long getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(Long idreserva) {
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

	public BarberiaDTO getBarberia() {
		return barberia;
	}

	public void setBarberia(BarberiaDTO barberia) {
		this.barberia = barberia;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	

	

	
	
	
}
