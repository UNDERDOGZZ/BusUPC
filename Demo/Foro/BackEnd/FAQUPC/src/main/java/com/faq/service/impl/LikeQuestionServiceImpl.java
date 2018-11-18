package com.faq.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.LikeQuestion;
import com.faq.repository.LikeQuestionRepository;
import com.faq.service.LikeQuestionService;
@Service
public class LikeQuestionServiceImpl implements LikeQuestionService {

	@Autowired
	private LikeQuestionRepository likeRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<LikeQuestion> findAll() throws Exception {
		return likeRepository.findAll();
	}

	@Transactional
	@Override
	public LikeQuestion save(LikeQuestion t) throws Exception {
		return likeRepository.save(t);
	}
	
	@Transactional
	@Override
	public LikeQuestion update(LikeQuestion t) throws Exception {
		return likeRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<LikeQuestion> findById(Integer id) throws Exception {
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

	@Transactional(readOnly = true)
	@Override
	public Optional<LikeQuestion> fetchLikeByQuestionsAndStudents(int questId, int studId) throws Exception {
		// TODO Auto-generated method stub
		return likeRepository.fetchLikeByQuestionsAndStudents(questId, studId);
	}

	@Transactional
	@Override
	public void deleteInBulk(int id) throws Exception {
		likeRepository.deleteInBulk(id);
	}

}
