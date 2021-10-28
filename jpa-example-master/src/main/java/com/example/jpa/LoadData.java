package com.example.jpa;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.jpa.entity.complex.estudiante.Estudiante;
import com.example.jpa.entity.complex.estudiante.Materia;
import com.example.jpa.entity.complex.estudiante.Matricula;
import com.example.jpa.entity.complex.estudiante.repositories.EstudianteRepository;
import com.example.jpa.entity.complex.estudiante.repositories.MateriaRepository;

@Configuration
class LoadData {

	@Bean
	CommandLineRunner initDatabase(MateriaRepository materiaRepository, EstudianteRepository estudianteRepository) {
		return args -> {
			System.out.println("Probando los repositorios Spring Data JPA");
			
			Materia desarrolloWeb = new Materia();
			desarrolloWeb.setNombre("Desarrollo Web");
			desarrolloWeb.setCreditos(4);
			materiaRepository.save(desarrolloWeb);
			
			Materia ingeSoftware = new Materia();
			ingeSoftware.setNombre("Ingenieria de Software");
			ingeSoftware.setCreditos(4);
			materiaRepository.save(ingeSoftware);
			
			Optional<Materia> opt =  materiaRepository.findMateriaByNombre("dddd");
			
			if (opt.isPresent()) {
				Materia m = opt.get();
				System.out.println(m);
			}
			
			Estudiante e = new Estudiante();
			e.setMatricula(new Matricula(getDate("01/01/2021"), 4000000));
			e.setCodigo("001");
			e.setNombre("Fernando");
			e.setMaterias(new ArrayList<>());
			e.getMaterias().add(desarrolloWeb);
			estudianteRepository.save(e);
			
			e = new Estudiante();
			e.setMatricula(new Matricula(getDate("31/12/2020"), 5500000));
			e.setCodigo("002");
			e.setNombre("Juanito Carrasco");
			e.setMaterias(new ArrayList<>());
			e.getMaterias().add(ingeSoftware);
			estudianteRepository.save(e);
			
			// Usando consultas derivadas desde el nombre del metodo
			List<Estudiante> estudiantes = estudianteRepository.findByNombreContains("ernan");
			estudiantes = estudianteRepository.findByNombreLike("%ernan%");
			estudiantes = estudianteRepository.findByMateriasNombre("Desarrollo Web");
			estudiantes = estudianteRepository.findByMatriculaFechaPagoBefore(getDate("31/12/2020"));
			estudiantes = estudianteRepository.findByMatriculaValorGreaterThan(5000000);
					
			// Usando consultas con @Query		
			estudiantes = estudianteRepository.getEstudiantesByNombre("Fer");
			estudiantes =estudianteRepository.getEstudiantesViendoMateriaJPQL("Desarrollo Web");
			estudiantes =estudianteRepository.getEstudiantesConpagoAntiguo(getDate("31/12/2020"));
			estudiantes = estudianteRepository.findEstudiantesByValorMatricula(5000000);
			
			System.out.println("Termina");
		};
	}
	
	Date getDate(String fecha) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.parse(fecha);
	}
	
}
