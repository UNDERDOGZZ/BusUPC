package com.faq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faq.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	@Query("select q from Question q where q.text like %?1%")
	List<Question> fetchByText(String text);
	
	@Query("select q from Question q order by q.rating desc")
	List<Question> fetchAllOrderByRating();
}
