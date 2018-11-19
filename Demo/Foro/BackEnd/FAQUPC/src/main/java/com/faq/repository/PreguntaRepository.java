package com.faq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faq.entities.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

	@Query("select p from Pregunta p where p.texto like %?1%")
	List<Pregunta> fetchByText(String text);
	
	@Query("select p from Pregunta p order by p.rating desc")
	List<Pregunta> fetchAllOrderByRating();
}
