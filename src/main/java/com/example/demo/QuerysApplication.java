package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class QuerysApplication implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(QuerysApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("BuscarQuery: "+this.estudianteService.buscarQuery("Ortega"));
		
		System.out.println("Buscar Named: "+this.estudianteService.buscarNamed("Ortega"));
	
		System.out.println("Buscar Named Query: "+ this.estudianteService.buscarNamedQuery("Ortega"));
		
		System.out.println("BuscarCriteria: "+this.estudianteService.buscarCriteriaAPIQuery("Ortega"));
		
		System.out.println("BuscarCriteriaDinamico: "+this.estudianteService.buscarEstudianteDinamicoCriteria("Jimmy", "Ortega", Double.valueOf(55)));
		
		System.out.println("Buscar TypedNative Query: "+this.estudianteService.buscarTypedNativeQuery("Ortega"));
	
		System.out.println("Buscar Native"+this.estudianteService.buscarNativeQuery("Ortega"));
	}

}
