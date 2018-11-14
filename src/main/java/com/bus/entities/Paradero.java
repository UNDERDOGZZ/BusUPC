package com.bus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="paraderos")
public class Paradero {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre", nullable =false, length =80)
	private String nombre;
	
	@Column(name="referencia", nullable =false, length =80)
	private String referencia;
	
	@ManyToOne
	@JoinColumn(name="ruta_id",nullable =false)
	private Ruta rutaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Ruta getRutaId() {
		return rutaId;
	}

	public void setRutaId(Ruta rutaId) {
		this.rutaId = rutaId;
	}
	
	
}
