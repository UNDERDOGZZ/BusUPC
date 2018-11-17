package com.faq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faq.entities.LikeQuestion;

@Repository
public interface LikeQuestionRepository extends JpaRepository<LikeQuestion, Integer> {

}
