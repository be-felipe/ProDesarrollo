package com.desarrollo.barberia.ibussiness;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desarrollo.barberia.model.Admin;

public interface Iadmin {
	public Page<Admin> getAdmins(Pageable pageable);
	public Admin crearAdmin(Admin newcli);
	public Optional<Admin> getAdminById(long id);
	public void DeleteAdmin(Admin id);
}
