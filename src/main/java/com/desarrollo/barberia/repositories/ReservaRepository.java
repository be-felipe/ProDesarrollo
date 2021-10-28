package com.desarrollo.barberia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Reserva;


public interface ReservaRepository extends PagingAndSortingRepository<Reserva, Long> {


}
