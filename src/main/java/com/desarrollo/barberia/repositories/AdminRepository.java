package com.desarrollo.barberia.repositories;

import org.springframework.data.repository.CrudRepository;

import com.desarrollo.barberia.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

}
