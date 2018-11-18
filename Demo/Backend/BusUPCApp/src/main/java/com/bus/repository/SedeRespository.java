package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.entities.Sede;

@Repository
public interface SedeRespository extends JpaRepository<Sede, Integer>{

	List<Sede> findByNombre(String nombre);
	
}
