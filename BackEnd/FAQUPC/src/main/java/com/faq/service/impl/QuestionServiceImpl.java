package com.faq.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.Question;
import com.faq.repository.QuestionRepository;
import com.faq.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Question> findAll() throws Exception {
		return questionRepository.findAll();
	}

	@Transactional
	@Override
	public Question save(Question t) throws Exception {
		return questionRepository.save(t);
	}
	
	@Transactional
	@Override
	public Question update(Question t) throws Exception {
		return questionRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Question> findById(Integer id) throws Exception {
		return questionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		questionRepository.deleteById(id);

	}


	@Transactional(readOnly = true)
	@Override
	public List<Question> fetchByText(String text) throws Exception {
		return questionRepository.fetchByText(text);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Question> fetchAllOrderByRating(){
		return questionRepository.fetchAllOrderByRating();
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
