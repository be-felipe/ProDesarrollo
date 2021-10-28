package com.example.jpa.entity.complex.empleado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Direccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	
	private String valor;
	
	@ManyToOne
	private Ciudad ciudad;
	
	@OneToOne(mappedBy = "direccion")
	private Empleado empleado;
	
	public Direccion() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}
