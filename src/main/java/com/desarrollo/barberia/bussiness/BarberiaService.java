package com.desarrollo.barberia.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.desarrollo.barberia.ibussiness.Ibarberia;
import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Barberia;
import com.desarrollo.barberia.model.Cliente;
import com.desarrollo.barberia.repositories.BarberiaRepository;

@Service
public class BarberiaService implements Ibarberia{

	@Autowired
	private BarberiaRepository barberiaRepository;

	
	@Override
    public Page<Barberia> getBarberias(Pageable pageable) {
		return barberiaRepository.findAll(pageable);
	}
    @Override
	public Barberia CrearBarberia(Barberia newcli) {
		return barberiaRepository.save(newcli);
	}
    
    @Override
	public Optional<Barberia> getBarberiaById(Long id) {
    	
		return barberiaRepository.findById(id);
	}
    @Override
  	public void DeleteBarberia(Barberia id)
  	{
    	barberiaRepository.delete(id);
  	}
	

	
	
	
}
