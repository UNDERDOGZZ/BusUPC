package com.faq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faq.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
