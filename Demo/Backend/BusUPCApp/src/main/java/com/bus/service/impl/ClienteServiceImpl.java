package com.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Cliente;
import com.bus.repository.ClienteRespository;
import com.bus.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRespository clienteRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Transactional
	@Override
	public Cliente save(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(t);
	}

	@Transactional
	@Override
	public Cliente update(Cliente t) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Cliente> findByNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findByNombre(nombre);
	}

	
}
