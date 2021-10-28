package com.desarrollo.barberia.ibussiness;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desarrollo.barberia.model.Cliente;

public interface Icliente {
	
	 public Cliente crearCliente(Cliente newcli);
	 public Optional<Cliente> getClienteById(Long id) ;
		public void DeleteCliente(Cliente id);
	    public Page<Cliente> getClientes(Pageable pageable);
		
}
