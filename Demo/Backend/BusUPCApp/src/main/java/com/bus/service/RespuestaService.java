package com.bus.service;

import java.util.List;

import com.bus.entities.Respuesta;

public interface RespuestaService extends CrudService<Respuesta> {

	List<Respuesta> fetchAllOrderByRating() throws Exception;
	
	List<Respuesta> fetchByQuestionID(int id) throws Exception;
	
	void deleteInBulk(int id) throws Exception;
}
