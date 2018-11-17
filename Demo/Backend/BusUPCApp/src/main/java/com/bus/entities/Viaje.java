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
@Table(name="viejes")
public class Viaje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="precio",nullable=false)
	private Double precio;
	
	@ManyToOne
	@JoinColumn(name="tarjet_id",nullable=false)
	private Tarjeta tarjetaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Tarjeta getTarjetaId() {
		return tarjetaId;
	}

	public void setTarjetaId(Tarjeta tarjetaId) {
		this.tarjetaId = tarjetaId;
	}
}
