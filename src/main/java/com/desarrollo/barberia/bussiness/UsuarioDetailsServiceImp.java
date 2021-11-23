package com.desarrollo.barberia.bussiness;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desarrollo.barberia.ibussiness.Iadmin;
import com.desarrollo.barberia.ibussiness.userDatailsService;
import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.repositories.AdminRepository;
@Service
public class UsuarioDetailsServiceImp implements userDatailsService{

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin loadUserByUsername (Long username) throws UsernameNotFoundException{
		Optional<Admin> usuario = adminRepository.findById(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("no se encontro el user");
		}
		return new Admin(usuario.get().getIdusuario(), usuario.get().getContrausuario(), usuario.get().getCorreousuario(),null, usuario.get().getNombreusuario());

		
	}
	
}
