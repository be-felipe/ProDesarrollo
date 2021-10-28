package com.example.jpa.entity.complex.estudiante.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.jpa.entity.complex.estudiante.Estudiante;
import com.example.jpa.entity.complex.estudiante.Materia;

public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
	
	// Buscar todos los estudiantes que su nombre contenta Fernando.
	List<Estudiante> findByNombreContains(String nombre);
	
	List<Estudiante> findByNombreLike(String nombre);	
		
	//	Buscar los estudiantes que están viendo la materia “Desarrollo Web”.
	List<Estudiante> findByMateriasNombre(String materia);
	
	// Buscar los estudiantes que están viendo la materia “Desarrollo Web”.
	List<Estudiante> findByMateriasIn(List<Materia> materia);
	
	// Buscar estudiantes que tenga una matricula con fecha de pago menor al 31 de diciembre
	List<Estudiante> findByMatriculaFechaPagoBefore(Date fecha);
	
	// Buscar estudiantes que hayan pagado por matricula un valor mayor a 5’000.000.
	List<Estudiante> findByMatriculaValorGreaterThan(double valor);
	
	@Query(value = "SELECT est FROM Estudiante est WHERE est.nombre LIKE %:nombre%")
//	@Query("SELECT e FROM Estudiante e where LOWER(e.nombre) like LOWER(:nombre))") 
	List<Estudiante> getEstudiantesByNombre(String nombre);
	
	
	@Query(value = "SELECT e from Estudiante e join e.materias m where upper(m.nombre) = upper(?1) ")
	List<Estudiante> getEstudiantesViendoMateriaJPQL(String materia);
	
	@Query(nativeQuery = true, 
			value = "SELECT e.* FROM estudiante e JOIN materia m ON e.materia_id = m.id WHERE m.nombre = :materia")
	List<Estudiante> getEstudiantesViendoMateriaNativo(@Param(value = "materia") String materia);
	
	@Query("SELECT e from Estudiante e where e.matricula.fechaPago <= ?1")
	List<Estudiante> getEstudiantesConpagoAntiguo(Date fecha);
	
	@Query("SELECT e from Estudiante e where e.matricula.valor > ?1")
	List<Estudiante> findEstudiantesByValorMatricula(double valor);
	
}
