package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entities.Paradero;

@Repository
public  interface ParaderoRespository extends JpaRepository<Paradero,Integer>{

	@Query("select p from Paradero p inner join p.rutaId r where r.id = ?1")
	List<Paradero> fetchByRutaId(int rutaId);
}
