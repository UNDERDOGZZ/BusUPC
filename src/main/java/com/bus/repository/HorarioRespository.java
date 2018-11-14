package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entities.Horario;

@Repository
public interface HorarioRespository extends JpaRepository<Horario,Integer>{

	@Query("select h from Horario h inner join h.rutaId r where r.id = ?1")
	List<Horario> fetchByRutaId(int id);
	
}
