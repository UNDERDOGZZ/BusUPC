package com.faq.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.LikeAnswer;
import com.faq.repository.LikeAnswerRepository;
import com.faq.service.LikeAnswerService;
@Service
public class LikeAnswerServiceImpl implements LikeAnswerService {

	@Autowired
	private LikeAnswerRepository likeRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<LikeAnswer> findAll() throws Exception {
		return likeRepository.findAll();
	}

	@Transactional
	@Override
	public LikeAnswer save(LikeAnswer t) throws Exception {
		return likeRepository.save(t);
	}
	
	@Transactional
	@Override
	public LikeAnswer update(LikeAnswer t) throws Exception {
		return likeRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<LikeAnswer> findById(Integer id) throws Exception {
		return likeRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		likeRepository.deleteById(id);

	}
	
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub	
	}

	@Override
	public Optional<LikeAnswer> fetchLikeByAnswersAndStudents(int ansId, int studId) throws Exception {
		// TODO Auto-generated method stub
		return likeRepository.fetchLikeByAnswersAndStudents(ansId, studId);
	}

}
