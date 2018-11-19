package com.faq.service;

import java.util.List;

import com.faq.entities.Pregunta;

public interface PreguntaService extends CrudService<Pregunta> {
	List<Pregunta> fetchByText(String dni) throws Exception;
	
	List<Pregunta> fetchAllOrderByRating() throws Exception;
}
