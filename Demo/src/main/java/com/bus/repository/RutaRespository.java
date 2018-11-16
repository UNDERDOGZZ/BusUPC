package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.entities.Ruta;

@Repository
public interface RutaRespository extends JpaRepository<Ruta, Integer>{

	
	List<Ruta> findByOrigenAndDestino(String origen, String destino); 
}
