package com.bus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rutas")
public class Ruta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "origen_id", nullable = false)
	private Sede origen;
	
	@ManyToOne
	@JoinColumn(name = "destino_id", nullable = false)
	private Sede destino;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sede getOrigen() {
		return origen;
	}

	public void setOrigen(Sede origen) {
		this.origen = origen;
	}

	public Sede getDestino() {
		return destino;
	}

	public void setDestino(Sede destino) {
		this.destino = destino;
	}
	
	
	
}
