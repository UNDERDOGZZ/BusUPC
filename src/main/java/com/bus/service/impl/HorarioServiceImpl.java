package com.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Horario;
import com.bus.repository.HorarioRespository;
import com.bus.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService{

	@Autowired
	private HorarioRespository horarioRespository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Horario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return horarioRespository.findAll();
	}

	@Transactional
	@Override
	public Horario save(Horario t) throws Exception {
		// TODO Auto-generated method stub
		return horarioRespository.save(t);
	}
	@Transactional
	@Override
	public Horario update(Horario t) throws Exception {
		// TODO Auto-generated method stub
		return horarioRespository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Horario> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return horarioRespository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		horarioRespository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		horarioRespository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Horario> fetchByRutaId(int id) throws Exception{
		// TODO Auto-generated method stub
		return horarioRespository.fetchByRutaId(id);
	}

	
}
