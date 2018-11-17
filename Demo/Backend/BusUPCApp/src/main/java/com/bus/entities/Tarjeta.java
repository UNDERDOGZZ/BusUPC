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
@Table(name="tarjetas")
public class Tarjeta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="numero_tarjeta",nullable=false)
	private Long numeroTarjeta;
	
	@Column(name="mes",nullable=false)
	private int mes;
	
	@Column(name="dia",nullable=false)
	private int dia;
	
	@Column(name="cvv",nullable=false)
	private int cvv;
	
	@Column(name="monto",nullable=false)
	private Double monto;
	
	@ManyToOne
	@JoinColumn(name="cliente_id",nullable=false)
	private Cliente clienteId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	
	
}
