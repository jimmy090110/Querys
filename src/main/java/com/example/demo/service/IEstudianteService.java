package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {
	
	public Estudiante buscarQuery(String apellido);
	
	public Estudiante buscarTyped(String apellido);
	
	public Estudiante buscarNamed(String apellido);
	
	public Estudiante buscarNamedQuery(String apellido);
	
	public Estudiante buscarNativeQuery(String apellido);
	
	public Estudiante buscarTypedNativeQuery(String apellido);
	
	public Estudiante buscarCriteriaAPIQuery(String apellido);
	
	public Estudiante buscarEstudianteDinamicoCriteria(String nombre, String apellido, Double peso);

	public int eliminarPorApellido(String apellido);
	
	public int actualizarPorApellido(String nombre,String apellido);
}
