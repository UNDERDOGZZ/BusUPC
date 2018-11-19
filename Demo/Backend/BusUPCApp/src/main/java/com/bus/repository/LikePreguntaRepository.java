package com.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entities.LikePregunta;

@Repository
public interface LikePreguntaRepository extends JpaRepository<LikePregunta, Integer> {
	
	@Query("select l from LikePregunta l where l.preguntaId.id =?1 and l.clienteId.id =?2")
	Optional<LikePregunta> fetchLikeByQuestionsAndStudents(int questId, int studId);

	@Modifying
	@Query("delete from LikePregunta l where l.preguntaId.id = ?1")
	void deleteInBulk(int id);
}
