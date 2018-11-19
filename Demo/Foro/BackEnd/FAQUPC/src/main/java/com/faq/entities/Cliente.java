package com.faq.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 3, message = "Primer nombre debe tener como minimo 2 caracteres")
	@Column(name = "nombre", nullable = false, length = 10)
	private String nombre;

	@Size(min = 3, message = "Apellido debe tener como minimo 2 caracteres")
	@Column(name = "apellido", nullable = false, length = 10)
	private String apellido;

	@Size(min = 3, message = "Codigo debe tener como minimo 5 caracteres")
	@Column(name = "codigo", nullable = false, length = 10)
	private String codigo;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

}
