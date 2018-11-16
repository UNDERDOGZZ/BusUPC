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
@Table(name="horarios")
public class Horario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="dia",nullable=false,length=15)
	private String dia;
	
	@Column(name="hora")
	private int  hora;
	
	@Column(name="minuto")
	private int  minuto;
	
	@ManyToOne
	@JoinColumn(name="ruta_id",nullable =false)
	private Ruta rutaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}



	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public Ruta getRutaId() {
		return rutaId;
	}

	public void setRutaId(Ruta rutaId) {
		this.rutaId = rutaId;
	}
}
