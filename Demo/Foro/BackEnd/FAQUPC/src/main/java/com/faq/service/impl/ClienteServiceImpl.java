package com.faq.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.Cliente;
import com.faq.repository.ClienteRepository;
import com.faq.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository studentRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
		return studentRepository.findAll();
	}

	@Transactional
	@Override
	public Cliente save(Cliente t) throws Exception {
		return studentRepository.save(t);
	}
	
	@Transactional
	@Override
	public Cliente update(Cliente t) throws Exception {
		return studentRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		return studentRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		studentRepository.deleteById(id);

	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
