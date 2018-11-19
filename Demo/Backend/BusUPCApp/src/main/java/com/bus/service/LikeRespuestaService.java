package com.bus.service;

import java.util.Optional;

import com.bus.entities.LikeRespuesta;

public interface LikeRespuestaService extends CrudService<LikeRespuesta>  {
	Optional<LikeRespuesta> fetchLikeByAnswersAndStudents(int ansId, int studId) throws Exception;

	void deleteInBulk(int id) throws Exception;
}

