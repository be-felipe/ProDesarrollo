package com.desarrollo.barberia.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Barberia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idbarberia;

	private String nombrebarberia;
	
	private String direccionbarberia;
	
	private float preciobarberia;
	
	private String logobarberia;
	@OneToMany(mappedBy ="barberia",fetch = FetchType.LAZY )
	
	private List<Reserva> reservas;
	
	public Barberia(Long idbarberia, String nombrebarberia, String direccionbarberia, float preciobarberia,
			String logobarberia) {
		super();
		this.idbarberia = idbarberia;
		this.nombrebarberia = nombrebarberia;
		this.direccionbarberia = direccionbarberia;
		this.preciobarberia = preciobarberia;
		this.logobarberia = logobarberia;
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
	public String getLogobarberia() {
		return logobarberia;
	}
	public void setLogobarberia(String logobarberia) {
		this.logobarberia = logobarberia;
	}
	
	

}