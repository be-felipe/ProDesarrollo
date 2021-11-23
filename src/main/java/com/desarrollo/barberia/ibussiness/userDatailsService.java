package com.desarrollo.barberia.ibussiness;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.desarrollo.barberia.model.Admin;

public interface userDatailsService {

	Admin loadUserByUsername(Long username) throws UsernameNotFoundException;

}
