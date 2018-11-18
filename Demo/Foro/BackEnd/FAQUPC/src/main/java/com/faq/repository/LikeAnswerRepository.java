package com.faq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faq.entities.LikeAnswer;

@Repository
public interface LikeAnswerRepository extends JpaRepository<LikeAnswer, Integer> {
	@Query("select l from LikeAnswer l where l.answerId.id =?1 and l.studentId.id =?2")
	Optional<LikeAnswer> fetchLikeByAnswersAndStudents(int ansId, int studId);
}
