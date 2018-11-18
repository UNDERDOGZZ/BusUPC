package com.faq.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faq.entities.Student;
import com.faq.repository.StudentRepository;
import com.faq.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> findAll() throws Exception {
		return studentRepository.findAll();
	}

	@Transactional
	@Override
	public Student save(Student t) throws Exception {
		return studentRepository.save(t);
	}
	
	@Transactional
	@Override
	public Student update(Student t) throws Exception {
		return studentRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Student> findById(Integer id) throws Exception {
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
