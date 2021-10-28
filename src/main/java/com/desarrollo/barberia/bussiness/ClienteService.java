package com.desarrollo.barberia.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.desarrollo.barberia.ibussiness.Icliente;
import com.desarrollo.barberia.model.Cliente;
import com.desarrollo.barberia.model.Reserva;
import com.desarrollo.barberia.repositories.ClienteRepository;

@Service
public class ClienteService implements Icliente  {
  
	@Autowired
	private ClienteRepository clienteRepository;

	    @Override
	    public Page<Cliente> getClientes(Pageable pageable) {
			return clienteRepository.findAll(pageable);
		}
	    @Override
	    public Cliente crearCliente(Cliente newcli) {
			return clienteRepository.save(newcli);
		}
	    
	    @Override
		public Optional<Cliente> getClienteById(Long id) {
	    	
			return clienteRepository.findById(id);
		}
	    @Override
	  	public void DeleteCliente(Cliente id)
	  	{
	    	clienteRepository.delete(id);
	  	}

	
}
