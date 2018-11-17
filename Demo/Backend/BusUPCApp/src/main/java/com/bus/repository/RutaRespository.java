package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entities.Ruta;

@Repository
public interface RutaRespository extends JpaRepository<Ruta, Integer>{

	@Query("select r from Ruta r join fetch r.origen o join fetch r.destino d where o.name like %?1% and d.name like %?2% ")
	List<Ruta> fetchByOrigenAndDestino(String origen, String destino); 
}
