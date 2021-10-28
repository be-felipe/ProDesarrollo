package com.desarrollo.barberia.jpa;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.desarrollo.barberia.bussiness.AdminService;
import com.desarrollo.barberia.bussiness.BarberiaService;
import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Barberia;
import com.desarrollo.barberia.model.Reserva;
import com.desarrollo.barberia.repositories.AdminRepository;
import com.desarrollo.barberia.repositories.BarberiaRepository;
import com.desarrollo.barberia.repositories.ReservaRepository;



@Configuration
public class Load {

	
	@Bean
	CommandLineRunner initDatabase(BarberiaRepository repository,ReservaRepository reservarepository) {
		return args -> {
			System.out.println("ENTRA");
			
			
			Barberia admin1=new Barberia();
			admin1.setDireccionbarberia("calle 22b n 68c 41");
			admin1.setLogobarberia("www.tulogo.com");
			admin1.setNombrebarberia("Barberia chama");
			admin1.setPreciobarberia(100);
			repository.save(admin1);
			
			Reserva ras= new Reserva();
			
			
			ras.setNombrereserva("Fulano");
			ras.setAsistio(true);
			ras.setBarberia(admin1);
			reservarepository.save(ras);
			/*
			Materia desarrolloWeb = new Materia();
			desarrolloWeb.setNombre("Desarrollo Web");
			desarrolloWeb.setCreditos(4);
			materiaRepository.save(desarrolloWeb);
			
			
			
			
			
			Optional<Materia> opt =  materiaRepository.findMateriaByNombre("dddd");
			
			if (opt.isPresent()) {
				Materia m = opt.get();
				System.out.println(m);
			}
			
			
			
		
			
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
			*/
			System.out.println("Termina");
		};
	}
	
	Date getDate(String fecha) throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return (Date) dateFormat.parse(fecha);
	}
}
