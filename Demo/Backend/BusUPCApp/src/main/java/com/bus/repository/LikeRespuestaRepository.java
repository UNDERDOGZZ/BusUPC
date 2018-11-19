package com.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entities.LikeRespuesta;

@Repository
public interface LikeRespuestaRepository extends JpaRepository<LikeRespuesta, Integer> {
	@Query("select l from LikeRespuesta l where l.respuestaId.id =?1 and l.clienteId.id =?2")
	Optional<LikeRespuesta> fetchLikeByAnswersAndStudents(int ansId, int studId);
	
	@Modifying
	@Query("delete from LikeRespuesta l where l.respuestaId.id = ?1")
	void deleteInBulk(int id);
}
