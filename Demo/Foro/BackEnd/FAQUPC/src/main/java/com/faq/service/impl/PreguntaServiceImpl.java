package com.faq.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.Pregunta;
import com.faq.repository.PreguntaRepository;
import com.faq.service.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService {

	@Autowired
	private PreguntaRepository questionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Pregunta> findAll() throws Exception {
		return questionRepository.findAll();
	}

	@Transactional
	@Override
	public Pregunta save(Pregunta t) throws Exception {
		return questionRepository.save(t);
	}
	
	@Transactional
	@Override
	public Pregunta update(Pregunta t) throws Exception {
		return questionRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Pregunta> findById(Integer id) throws Exception {
		return questionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		questionRepository.deleteById(id);

	}


	@Transactional(readOnly = true)
	@Override
	public List<Pregunta> fetchByText(String text) throws Exception {
		return questionRepository.fetchByText(text);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Pregunta> fetchAllOrderByRating(){
		return questionRepository.fetchAllOrderByRating();
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
