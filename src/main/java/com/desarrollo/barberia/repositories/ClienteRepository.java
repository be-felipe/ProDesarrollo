package com.desarrollo.barberia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Barberia;
import com.desarrollo.barberia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
