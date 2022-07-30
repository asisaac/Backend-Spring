package com.datapar.encuesta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="satisfaccion")
public class Satisfaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre", length = 60, nullable=false)
	private String nombre;	
	
	@Column(name="email", length = 60, nullable = false, unique = true)
	private String email;
	
	@Column(name="calificacion")
	private int calificacion;
	
	@Column(name="obs", length = 500, nullable = true)
	private String obs;
	
	@Column(name="telefono", length = 30, nullable = true)
	private String telefono;
	
	@Column(name="horario", length = 60, nullable = true)
	private String horario;
	
	public Satisfaccion() {
		
	}

	public Satisfaccion(String nombre, String email, int calificacion, String obs,
			String telefono, String horario) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.calificacion = calificacion;
		this.obs = obs;
		this.telefono = telefono;
		this.horario = horario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}	
}