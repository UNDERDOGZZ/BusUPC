package com.faq.service;

import java.util.List;

import com.faq.entities.Respuesta;

public interface RespuestaService extends CrudService<Respuesta> {

	List<Respuesta> fetchAllOrderByRating() throws Exception;
	
	List<Respuesta> fetchByQuestionID(int id) throws Exception;
	
	void deleteInBulk(int id) throws Exception;
}
