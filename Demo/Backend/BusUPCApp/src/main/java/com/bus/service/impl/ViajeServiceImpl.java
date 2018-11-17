package com.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Viaje;
import com.bus.repository.ViajeRepository;
import com.bus.service.ViajeService;

@Service
public class ViajeServiceImpl implements ViajeService{

	private ViajeRepository viajeRepository;

	@Transactional(readOnly =true)
	@Override
	public List<Viaje> findAll() throws Exception {
		// TODO Auto-generated method stub
		return viajeRepository.findAll();
	}

	@Transactional
	@Override
	public Viaje save(Viaje t) throws Exception {
		// TODO Auto-generated method stub
		return viajeRepository.save(t);
	}

	@Transactional
	@Override
	public Viaje update(Viaje t) throws Exception {
		// TODO Auto-generated method stub
		return viajeRepository.save(t);
	}

	@Transactional(readOnly =true)
	@Override
	public Optional<Viaje> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return viajeRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		viajeRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		viajeRepository.deleteAll();
	}	
}
