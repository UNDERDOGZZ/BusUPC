package com.faq.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.Respuesta;
import com.faq.service.RespuestaService;
import com.faq.repository.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService {

	@Autowired
	private RespuestaRepository answerRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Respuesta> findAll() throws Exception{
		return answerRepository.findAll();
	}

	@Transactional
	@Override
	public Respuesta save(Respuesta t) throws Exception{
		return answerRepository.save(t);
	}

	@Transactional
	@Override
	public Respuesta update(Respuesta t) throws Exception{
		return answerRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Respuesta> findById(Integer id) throws Exception{
		return answerRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception{
		answerRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Respuesta> fetchAllOrderByRating() throws Exception{
		return answerRepository.fetchAllOrderByRating();
	}
	
	@Override
	public void deleteAll() throws Exception{
	}

	@Transactional(readOnly = true)
	@Override
	public List<Respuesta> fetchByQuestionID(int id) throws Exception {
		return answerRepository.fetchByQuestionID(id);
	}

	@Transactional
	@Override
	public void deleteInBulk(int id) throws Exception {
		answerRepository.deleteInBulk(id);
	}
}
