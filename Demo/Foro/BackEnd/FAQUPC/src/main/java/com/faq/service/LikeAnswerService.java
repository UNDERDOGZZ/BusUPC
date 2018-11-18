package com.faq.service;

import java.util.Optional;

import com.faq.entities.LikeAnswer;

public interface LikeAnswerService extends CrudService<LikeAnswer>  {
	Optional<LikeAnswer> fetchLikeByAnswersAndStudents(int ansId, int studId) throws Exception;
}

