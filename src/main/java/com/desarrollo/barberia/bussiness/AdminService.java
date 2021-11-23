package com.desarrollo.barberia.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.desarrollo.barberia.ibussiness.Iadmin;
import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Cliente;
import com.desarrollo.barberia.repositories.AdminRepository;

@Service
public class AdminService implements Iadmin {

	@Autowired
	private AdminRepository adminRepository;
 
	
	@Override
    public Page<Admin> getAdmins(Pageable pageable) {
		return adminRepository.findAll(pageable);
	}
    @Override
	public Admin crearAdmin(Admin newcli) {
		return adminRepository.save(newcli);
	}
    
    @Override
	public Optional<Admin> getAdminById(long id) {
    	
		return adminRepository.findById(id);
	}
    @Override
  	public void DeleteAdmin(Admin id)
  	{
    	adminRepository.delete(id);
  	}
	
	
	
}
