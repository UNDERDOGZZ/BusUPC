package com.faq.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.LikeRespuesta;
import com.faq.repository.LikeRespuestaRepository;
import com.faq.service.LikeRespuestaService;
@Service
public class LikeRespuestaServiceImpl implements LikeRespuestaService {

	@Autowired
	private LikeRespuestaRepository likeRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<LikeRespuesta> findAll() throws Exception {
		return likeRepository.findAll();
	}

	@Transactional
	@Override
	public LikeRespuesta save(LikeRespuesta t) throws Exception {
		return likeRepository.save(t);
	}
	
	@Transactional
	@Override
	public LikeRespuesta update(LikeRespuesta t) throws Exception {
		return likeRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<LikeRespuesta> findById(Integer id) throws Exception {
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
	public Optional<LikeRespuesta> fetchLikeByAnswersAndStudents(int ansId, int studId) throws Exception {
		// TODO Auto-generated method stub
		return likeRepository.fetchLikeByAnswersAndStudents(ansId, studId);
	}

	@Transactional
	@Override
	public void deleteInBulk(int id) throws Exception {
		likeRepository.deleteInBulk(id);
	}
}
