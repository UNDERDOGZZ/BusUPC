package com.faq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.faq.entities.Pregunta;

@Entity
@Table(name = "likePreguntas")
public class LikePregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "pregunta_id", nullable = true)
	private Pregunta preguntaId;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente clienteId;
	

	@Column(name = "liked", nullable = false)
	private boolean liked = false;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public boolean isLiked() {
		return liked;
	}


	public void setLiked(boolean liked) {
		this.liked = liked;
	}

		
}
