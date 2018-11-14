package com.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Sede;
import com.bus.repository.SedeRespository;
import com.bus.service.SedeService;

@Service
public class SedeServiceImpl implements SedeService {

	@Autowired
	private SedeRespository sedeRespository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Sede> findAll() throws Exception {
		// TODO Auto-generated method stub
		return sedeRespository.findAll();
	}

	@Transactional
	@Override
	public Sede save(Sede t) throws Exception {
		// TODO Auto-generated method stub
		return sedeRespository.save(t);
	}

	@Transactional
	@Override
	public Sede update(Sede t) throws Exception {
		// TODO Auto-generated method stub
		return sedeRespository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Sede> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return sedeRespository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		sedeRespository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		sedeRespository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Sede> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
