package com.bus.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.LikePregunta;
import com.bus.repository.LikePreguntaRepository;
import com.bus.service.LikePreguntaService;
@Service
public class LikePreguntaServiceImpl implements LikePreguntaService {

	@Autowired
	private LikePreguntaRepository likeRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<LikePregunta> findAll() throws Exception {
		return likeRepository.findAll();
	}

	@Transactional
	@Override
	public LikePregunta save(LikePregunta t) throws Exception {
		return likeRepository.save(t);
	}
	
	@Transactional
	@Override
	public LikePregunta update(LikePregunta t) throws Exception {
		return likeRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<LikePregunta> findById(Integer id) throws Exception {
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
	public Optional<LikePregunta> fetchLikeByQuestionsAndStudents(int questId, int studId) throws Exception {
		// TODO Auto-generated method stub
		return likeRepository.fetchLikeByQuestionsAndStudents(questId, studId);
	}

	@Transactional
	@Override
	public void deleteInBulk(int id) throws Exception {
		likeRepository.deleteInBulk(id);
	}

}
