package com.desarrollo.barberia.repositories;
import java.util.Optional;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.desarrollo.barberia.model.Admin;
import com.desarrollo.barberia.model.Barberia;
@Primary
@ComponentScan("com.desarrollo.barberia.model")
public interface BarberiaRepository extends JpaRepository<Barberia,Long>{
	

}
