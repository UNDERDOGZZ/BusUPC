package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.entities.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer>{
	
}
