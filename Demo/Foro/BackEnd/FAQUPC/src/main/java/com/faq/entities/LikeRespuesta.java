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
@Table(name = "likeRespuestas")
public class LikeRespuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente clienteId;
	
	@ManyToOne
	@JoinColumn(name = "respuesta_id", nullable = false)
	private Respuesta respuestaId;

	@Column(name = "liked", nullable = false)
	private boolean liked = false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public Respuesta getRespuestaId() {
		return respuestaId;
	}

	public void setRespuestaId(Respuesta respuestaId) {
		this.respuestaId = respuestaId;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	
}
