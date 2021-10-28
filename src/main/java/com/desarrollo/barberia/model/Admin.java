package com.desarrollo.barberia.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
@Entity
public class Admin extends Usuario{
	
	
	
	public Admin(long idusuario, String nombreusuario, String correousuario, String contrausuario) {
		super(idusuario, nombreusuario, correousuario, contrausuario);
		
	}

	public Admin() {
		
	}

	
	
	
	
}
