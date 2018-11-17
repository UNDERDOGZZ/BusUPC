package com.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.entities.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer>{
	
}
