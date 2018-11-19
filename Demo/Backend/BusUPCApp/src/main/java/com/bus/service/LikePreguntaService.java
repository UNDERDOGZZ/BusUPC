package com.bus.service;

import java.util.Optional;

import com.bus.entities.LikePregunta;

public interface LikePreguntaService extends CrudService<LikePregunta>  {
	Optional<LikePregunta> fetchLikeByQuestionsAndStudents(int questId, int studId) throws Exception;
	
	void deleteInBulk(int id) throws Exception;
}
