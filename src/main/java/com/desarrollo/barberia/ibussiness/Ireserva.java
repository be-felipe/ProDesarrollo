package com.desarrollo.barberia.ibussiness;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desarrollo.barberia.model.Reserva;

public interface Ireserva {
	public Page<Reserva> getReservas(Pageable pageable);
	public Reserva crearResrva(Reserva newReserva);
	public Optional<Reserva> getReservaById(Long id); 
  	public void DeleteResrva(Reserva id);
}
