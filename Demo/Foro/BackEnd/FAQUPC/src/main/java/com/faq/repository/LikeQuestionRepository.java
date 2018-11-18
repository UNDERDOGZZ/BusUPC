package com.faq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faq.entities.LikeQuestion;

@Repository
public interface LikeQuestionRepository extends JpaRepository<LikeQuestion, Integer> {
	
	@Query("select l from LikeQuestion l where l.questionId.id =?1 and l.studentId.id =?2")
	Optional<LikeQuestion> fetchLikeByQuestionsAndStudents(int questId, int studId);

	@Modifying
	@Query("delete from LikeQuestion l where l.questionId.id = ?1")
	void deleteInBulk(int id);
}
