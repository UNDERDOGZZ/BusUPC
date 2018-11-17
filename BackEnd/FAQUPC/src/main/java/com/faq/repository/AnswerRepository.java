package com.faq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faq.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	
	@Query("select a from Answer a order by a.rating desc ")
	List<Answer> fetchAllOrderByRating();
	
	@Query("select a from Answer a where a.questionId.id =?1 order by a.rating desc")
	List<Answer> fetchByQuestionID(int id);
}
