package com.desarrollo.barberia.model;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
@Entity
public class Admin extends Usuario{
	
	
	
	

	public Admin(Long idusuario, String nombreusuario, String correousuario, Role rol, String contrausuario) {
		super(idusuario, nombreusuario, correousuario, rol, contrausuario);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		
	}

	
	
	
	
}
