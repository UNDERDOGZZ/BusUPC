package com.bus.service;

import java.util.List;

import com.bus.entities.Pregunta;

public interface PreguntaService extends CrudService<Pregunta> {
	List<Pregunta> fetchByText(String dni) throws Exception;
	
	List<Pregunta> fetchAllOrderByRating() throws Exception;
}
