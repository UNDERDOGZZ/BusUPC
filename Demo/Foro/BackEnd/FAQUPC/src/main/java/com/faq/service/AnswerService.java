package com.faq.service;

import java.util.List;

import com.faq.entities.Answer;

public interface AnswerService extends CrudService<Answer> {

	List<Answer> fetchAllOrderByRating() throws Exception;
	
	List<Answer> fetchByQuestionID(int id) throws Exception;
}
