package com.desarrollo.barberia.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Barberia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idbarberia;

	private String nombrebarberia;
	
	private String direccionbarberia;
	
	private float preciobarberia;

	private String fotobarber;
	
	
	@OneToMany(mappedBy ="barberia" )
	
	private List<Reserva> reservas;
	
	
	
	public Barberia(Long idbarberia, String nombrebarberia, String direccionbarberia, float preciobarberia,
			String fotobarber, List<Reserva> reservas) {
		super();
		this.idbarberia = idbarberia;
		this.nombrebarberia = nombrebarberia;
		this.direccionbarberia = direccionbarberia;
		this.preciobarberia = preciobarberia;
		this.fotobarber = fotobarber;
		this.reservas = reservas;
	}
	public Barberia() {
		
	}
	public Long getIdbarberia() {
		return idbarberia;
	}
	
	public String getNombrebarberia() {
		return nombrebarberia;
	}
	public void setNombrebarberia(String nombrebarberia) {
		this.nombrebarberia = nombrebarberia;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	public void setIdbarberia(Long idbarberia) {
		this.idbarberia = idbarberia;
	}
	public String getDireccionbarberia() {
		return direccionbarberia;
	}
	public void setDireccionbarberia(String direccionbarberia) {
		this.direccionbarberia = direccionbarberia;
	}
	public float getPreciobarberia() {
		return preciobarberia;
	}
	public void setPreciobarberia(float preciobarberia) {
		this.preciobarberia = preciobarberia;
	}
	
	public String getFotobarber() {
		return fotobarber;
	}
	public void setFotobarber(String fotobarber) {
		this.fotobarber = fotobarber;
	}
	
	

}