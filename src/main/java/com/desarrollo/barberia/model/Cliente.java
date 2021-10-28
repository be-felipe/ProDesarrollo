package com.desarrollo.barberia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;



@Entity
public class Cliente extends Usuario {

	public Cliente(Long idusuario, String nombreusuario, String correousuario, String contrausuario) {
		super(idusuario, nombreusuario, correousuario, contrausuario);
	}
	@OneToMany (mappedBy = "cliente" )
	private List<Reserva> reservas;
}
