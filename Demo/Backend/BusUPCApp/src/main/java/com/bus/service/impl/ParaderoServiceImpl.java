package com.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Paradero;
import com.bus.repository.ParaderoRespository;
import com.bus.service.ParaderoService;

@Service
public class ParaderoServiceImpl implements ParaderoService {

	@Autowired
	private ParaderoRespository paraderoRespository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Paradero> findAll() throws Exception {
		// TODO Auto-generated method stub
		return paraderoRespository.findAll();
	}

	@Transactional
	@Override
	public Paradero save(Paradero t) throws Exception {
		// TODO Auto-generated method stub
		return paraderoRespository.save(t);
	}

	@Transactional
	@Override
	public Paradero update(Paradero t) throws Exception {
		// TODO Auto-generated method stub
		return paraderoRespository.save(t);
	}
	@Transactional(readOnly=true)
	@Override
	public Optional<Paradero> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return paraderoRespository.findById(id);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		paraderoRespository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		paraderoRespository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Paradero> fetchByRutaId(int rutaId) throws Exception {
		// TODO Auto-generated method stub
		return paraderoRespository.fetchByRutaId(rutaId);
	}

	
}
