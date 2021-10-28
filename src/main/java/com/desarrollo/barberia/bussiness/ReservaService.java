package com.desarrollo.barberia.bussiness;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.desarrollo.barberia.ibussiness.Ireserva;
import com.desarrollo.barberia.model.Reserva;
import com.desarrollo.barberia.repositories.ReservaRepository;

@Service
public class ReservaService  implements Ireserva{
    @Autowired
	private ReservaRepository reservaRepository;
    @Override
    public Page<Reserva> getReservas(Pageable pageable) {
		return reservaRepository.findAll(pageable);
	}
    @Override
	public Reserva crearResrva(Reserva newReserva) {
		return reservaRepository.save(newReserva);
	}
    
    @Override
	public Optional<Reserva> getReservaById(Long id) {
    	
		return reservaRepository.findById(id);
	}
    @Override
  	public void DeleteResrva(Reserva id)
  	{
    	reservaRepository.delete(id);
  	}
    


	
	
}
