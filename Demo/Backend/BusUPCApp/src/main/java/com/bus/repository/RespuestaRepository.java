package com.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entities.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {
	
	@Query("select r from Respuesta r order by r.rating desc ")
	List<Respuesta> fetchAllOrderByRating();
	
	@Query("select r from Respuesta r where r.preguntaId.id =?1 order by r.rating desc")
	List<Respuesta> fetchByQuestionID(int id);
	

	@Modifying
	@Query("delete from Respuesta r where r.preguntaId.id = ?1")
	void deleteInBulk(int id);
}
