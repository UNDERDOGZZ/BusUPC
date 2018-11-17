package com.faq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, message = "Primer debe tener como minimo 2 caracteres")
	@Column(name = "firstName", nullable = false, length = 10)
	private String firstName;

	@Size(min = 3, message = "Apellido debe tener como minimo 2 caracteres")
	@Column(name = "lastName", nullable = false, length = 10)
	private String lastName;

	@Size(min = 3, message = "Code debe tener como minimo 5 caracteres")
	@Column(name = "code", nullable = false, length = 10)
	private String code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
