package com.example.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
@NamedQuery(name = "Estudiante.buscarPorApelldio",query = "Select e from Estudiante e WHERE e.apellido=:datoApellido")
@NamedNativeQuery(name = "Estudiante.buscarTypedNative",query = "Select * from estudiante WHERE estu_apellido=:datoApellido", resultClass = Estudiante.class)
public class Estudiante {
	
	@Id 
	@GeneratedValue(generator = "seq_estu", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_estu", sequenceName = "seq_estu", allocationSize = 1)

	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_nombre") 
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;
	
	@Column(name = "estu_peso")
	private Double peso;
	
	
	// toString
	

	// Get and Set
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", peso=" + peso + "]";
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
}


