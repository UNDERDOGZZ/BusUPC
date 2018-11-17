package com.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Ruta;
import com.bus.repository.RutaRespository;
import com.bus.service.RutaService;

@Service
public class RutaServiceImpl implements RutaService{

	@Autowired
	private RutaRespository rutaRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Ruta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return rutaRepository.findAll();
	}

	@Transactional
	@Override
	public Ruta save(Ruta t) throws Exception {
		// TODO Auto-generated method stub
		return rutaRepository.save(t);
	}

	@Transactional
	@Override
	public Ruta update(Ruta t) throws Exception {
		// TODO Auto-generated method stub
		return rutaRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Ruta> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return rutaRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		rutaRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		rutaRepository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Ruta> fetchByOrigenAndDestino(String origen, String destino) throws Exception {
		// TODO Auto-generated method stub
		return rutaRepository.fetchByOrigenAndDestino(origen, destino);
	}

	
}
