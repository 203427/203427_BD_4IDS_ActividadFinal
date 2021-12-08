package com.example.lorenzo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "duenio")
public class Duenio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDuenio;
	private String nombreDuenio;
	private String direccionDuenio;
	private String telefonoDuenio;

	public Duenio() {
		
	}

	public Duenio(int idDuenio, String nombreDuenio, String direccionDuenio, String telefonoDuenio) {
		super();
		this.idDuenio = idDuenio;
		this.nombreDuenio = nombreDuenio;
		this.direccionDuenio = direccionDuenio;
		this.telefonoDuenio = telefonoDuenio;
	}

	public int getIdDuenio() {
		return idDuenio;
	}

	public void setIdDuenio(int idDuenio) {
		this.idDuenio = idDuenio;
	}

	public String getNombreDuenio() {
		return nombreDuenio;
	}

	public void setNombreDuenio(String nombreDuenio) {
		this.nombreDuenio = nombreDuenio;
	}

	public String getDireccionDuenio() {
		return direccionDuenio;
	}

	public void setDireccionDuenio(String direccionDuenio) {
		this.direccionDuenio = direccionDuenio;
	}

	public String getTelefonoDuenio() {
		return telefonoDuenio;
	}

	public void setTelefonoDuenio(String telefonoDuenio) {
		this.telefonoDuenio = telefonoDuenio;
	}
	
}
