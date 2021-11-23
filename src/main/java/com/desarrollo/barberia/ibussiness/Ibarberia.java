package com.desarrollo.barberia.ibussiness;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desarrollo.barberia.model.Barberia;

public interface Ibarberia {
	public Page<Barberia> getBarberias(Pageable pageable);
	public Barberia CrearBarberia(Barberia newcli);
	public Optional<Barberia> getBarberiaById(Long id);
	public void DeleteBarberia(Barberia id);
	public void DeleteBarberiaId(Long id);
}
