package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepo;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public Estudiante buscarQuery(String apellido) {
		
		return this.estudianteRepo.seleccionarQuery(apellido);
	}

	@Override
	public Estudiante buscarTyped(String apellido) {
		
		return this.estudianteRepo.seleccionarTyped(apellido);
	}

	@Override
	public Estudiante buscarNamed(String apellido) {
		
		return this.estudianteRepo.seleccionarNamed(apellido);
	}

	@Override
	public Estudiante buscarNamedQuery(String apellido) {
		
		return this.estudianteRepo.seleccionarNamedQuery(apellido);
	}

	@Override
	public Estudiante buscarNativeQuery(String apellido) {
		
		return this.estudianteRepo.seleccionarNativeQuery(apellido);
	}

	@Override
	public Estudiante buscarTypedNativeQuery(String apellido) {

		return this.estudianteRepo.seleccionarTypedNativeQuery(apellido);
	}

	@Override
	public Estudiante buscarCriteriaAPIQuery(String apellido) {

		return this.estudianteRepo.seleccionarCriteriaAPIQuery(apellido);
	}

	@Override
	public Estudiante buscarEstudianteDinamicoCriteria(String nombre, String apellido, Double peso) {
	
		return this.estudianteRepo.seleccionarEstudianteDinamicoCriteria(nombre, apellido, peso);
	}

}
