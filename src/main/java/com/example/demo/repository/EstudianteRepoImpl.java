package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	//Query
	@Override
	public Estudiante seleccionarQuery(String apellido) {
		Query myQuery = this.entityManager.createQuery("Select e from Estudiante e WHERE e.apellido =:datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		
		return (Estudiante) myQuery.getSingleResult();
	}

	//Typed Query
	@Override
	public Estudiante seleccionarTyped(String apellido) {
		TypedQuery<Estudiante>myQuery= this.entityManager.createQuery("Select e from Estudiante e WHERE e.apellido =:datoApellido",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}
	
	
	//NamedQuery
	@Override
	public Estudiante seleccionarNamed(String apellido) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApelldio",Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		
		
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarNamedQuery(String apellido) {
		
		return null;
	}

	@Override
	public Estudiante seleccionarNativeQuery(String apellido) {
		Query myQuery = this.entityManager.createNativeQuery("Select * from estudiante WHERE estu_apellido=:datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarTypedNativeQuery(String apellido) {
		TypedQuery<Estudiante>myQuery= this.entityManager.createNamedQuery("Estudiante.buscarTypedNative", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarCriteriaAPIQuery(String apellido) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante>myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
		Root<Estudiante>myTablaFrom = myCriteriaQuery.from(Estudiante.class);
		Predicate pApellido = myBuilder.equal(myTablaFrom.get("apellido"), apellido);
		myCriteriaQuery.select(myTablaFrom).where(pApellido);
		TypedQuery<Estudiante>myQueryFinal =  this.entityManager.createQuery(myCriteriaQuery);
		return myQueryFinal.getSingleResult();
	}

	@Override
	public Estudiante seleccionarEstudianteDinamicoCriteria(String nombre, String apellido, Double peso) {
		// 0. declaro un constructor
				CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
				// 1. Tipo de retorno que tiene mi Query
				CriteriaQuery<Estudiante> myCriteriaQuery = myBuilder.createQuery(Estudiante.class);
				// 2. Empezamos a crear el SQL
				// 2.1 Definimos el from (Root)
				Root<Estudiante> myTablaFrom = myCriteriaQuery.from(Estudiante.class); // From Estudiante
				// 3. construccion de las condiciones
				// Si el peso > a 100 , e.nombre = AND e.apellido=
				// si el peso <= a 100, e.nombre = OR e.apellido?
				// AND y OR son predicados distintos
				// e.nombre=?
				Predicate pNombre = myBuilder.equal(myTablaFrom.get("nombre"), nombre);

				// e.apellido=?
				Predicate pApellido = myBuilder.equal(myTablaFrom.get("apellido"), apellido);

				Predicate predicadoFinal = null;
				if (peso.compareTo(Double.valueOf(100)) <= 0) {
					predicadoFinal = myBuilder.or(pNombre, pApellido);
				} else {
					predicadoFinal = myBuilder.and(pNombre, pApellido);
				}

				// 4. Armamos mi SQL final
				myCriteriaQuery.select(myTablaFrom).where(predicadoFinal);

				// 5. Laejecución del Query la realizamos con TypedQuery
				TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);

				return myQueryFinal.getSingleResult();
	}

	@Override
	public int eliminarPorApellido(String apellido) {

		Query myQuery = this.entityManager.createQuery("Delete from Estudiante e WHERE e.apellido=:datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarPorApellido(String nombre, String apellido) {
		Query myQuery= this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre=:datoNombre WHERE e.apellido=:datoApellido");
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		
		return myQuery.executeUpdate();
	}



	

}
