package com.example.jpa.entity.complex.estudiante.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.jpa.entity.complex.estudiante.Materia;

public interface MateriaRepository extends CrudRepository<Materia, Long> {
	
	@Query(value = "SELECT m FROM Materia m WHERE LOWER(m.nombre) = LOWER(:nombre)")
	Optional<Materia> findMateriaByNombre(@Param(value = "nombre") String nombre);

}



