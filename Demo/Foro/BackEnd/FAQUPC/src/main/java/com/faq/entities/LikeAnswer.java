package com.faq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "likeAnswers")
public class LikeAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student studentId;
	
	@ManyToOne
	@JoinColumn(name = "answer_id", nullable = false)
	private Answer answerId;

	@Column(name = "liked", nullable = false)
	private boolean liked = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public Answer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Answer answerId) {
		this.answerId = answerId;
	}
		
}
