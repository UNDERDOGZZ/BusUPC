package com.faq.service;

import java.util.List;

import com.faq.entities.Question;

public interface QuestionService extends CrudService<Question> {
	List<Question> fetchByText(String dni) throws Exception;
	
	List<Question> fetchAllOrderByRating() throws Exception;
}
