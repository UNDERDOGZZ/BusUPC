package com.faq.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.Answer;
import com.faq.service.AnswerService;
import com.faq.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerRepository answerRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Answer> findAll() throws Exception{
		return answerRepository.findAll();
	}

	@Transactional
	@Override
	public Answer save(Answer t) throws Exception{
		return answerRepository.save(t);
	}

	@Transactional
	@Override
	public Answer update(Answer t) throws Exception{
		return answerRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Answer> findById(Integer id) throws Exception{
		return answerRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception{
		answerRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Answer> fetchAllOrderByRating() throws Exception{
		return answerRepository.fetchAllOrderByRating();
	}
	
	@Override
	public void deleteAll() throws Exception{
	}
}
