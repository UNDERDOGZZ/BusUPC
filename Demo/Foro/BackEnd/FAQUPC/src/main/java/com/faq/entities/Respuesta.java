package com.faq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.faq.entities.Pregunta;

@Entity
@Table(name = "respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, message = "Texto debe tener como minimo 10 caracteres")
	@Column(name = "texto", nullable = false, length = 150)
	private String texto;

	@Column(name = "rating", nullable = false)
	private int rating;
	
	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Pregunta preguntaId;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Cliente clienteId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Pregunta getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Pregunta preguntaId) {
		this.preguntaId = preguntaId;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
