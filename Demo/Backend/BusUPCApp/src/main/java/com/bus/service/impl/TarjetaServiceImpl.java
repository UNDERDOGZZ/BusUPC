package com.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Tarjeta;
import com.bus.repository.TarjetaRepository;
import com.bus.service.TarjetaService;

@Service
public class TarjetaServiceImpl implements TarjetaService{

	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Tarjeta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepository.findAll();
	}

	@Transactional
	@Override
	public Tarjeta save(Tarjeta t) throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepository.save(t);
	}

	@Transactional
	@Override
	public Tarjeta update(Tarjeta t) throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Tarjeta> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return tarjetaRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tarjetaRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		tarjetaRepository.deleteAll();
	}

	
}
