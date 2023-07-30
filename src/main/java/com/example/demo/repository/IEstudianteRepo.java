package com.example.demo.repository;


import com.example.demo.repository.modelo.Estudiante;


public interface IEstudianteRepo {
	
	
	public Estudiante seleccionarQuery(String apellido);
	
	public Estudiante seleccionarTyped(String apellido);
	
	public Estudiante seleccionarNamed(String apellido);
	
	public Estudiante seleccionarNamedQuery(String apellido);
	
	public Estudiante seleccionarNativeQuery(String apellido);
	
	public Estudiante seleccionarTypedNativeQuery(String apellido);
	
	public Estudiante seleccionarCriteriaAPIQuery(String apellido);
	
	public Estudiante seleccionarEstudianteDinamicoCriteria(String nombre, String apellido, Double peso);
	
	
	

}
