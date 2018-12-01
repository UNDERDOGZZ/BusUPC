package com.bus.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.entities.Product;
import com.bus.repository.ProductRepository;
import com.bus.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Product> findAll() throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Transactional
	@Override
	public Product save(Product t) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.save(t);
	}

	@Transactional
	@Override
	public Product update(Product t) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Product> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Product> findByDateBetween(LocalDate startDate, LocalDate endDate) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.findByDateBetween(startDate, endDate);
	}

	

	
	
		
}
