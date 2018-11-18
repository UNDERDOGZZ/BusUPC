package com.faq.service;

import java.util.List;
import java.util.Optional;

import com.faq.entities.LikeQuestion;

public interface LikeQuestionService extends CrudService<LikeQuestion>  {
	Optional<LikeQuestion> fetchLikeByQuestionsAndStudents(int questId, int studId) throws Exception;
	
	void deleteInBulk(int id) throws Exception;
}
