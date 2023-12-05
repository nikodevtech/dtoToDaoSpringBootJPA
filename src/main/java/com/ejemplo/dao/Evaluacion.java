package com.ejemplo.dao;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 * Clase DAO que representa la entidad Evaluacion en el sistema.
 * Esta clase se utiliza para almacenar información sobre las evaluaciones realizadas.
 * La información se persiste en la base de datos mediante JPA.
 */
@Entity
@Table(name = "eva_cat_evaluacion", schema = "sc_evaluacion")
public class Evaluacion {
	
	//Atributos
	
	@Id
	@Column(name = "cod_evaluacion", unique = true, nullable = false)
	private String codEvaluacion;
	
	@Column(name = "desc_evaluacion", nullable = false)
	private String descEvaluacion;
	
	@OneToMany(mappedBy = "evaluacion") 
	List<Nota> listaNotasEvaluacion = new ArrayList<>();

	
	//Constructores
	
	public Evaluacion() {
		super();
	}

	public Evaluacion(String codEvaluacion, String descEvaluacion) {
		super();
		this.codEvaluacion = codEvaluacion;
		this.descEvaluacion = descEvaluacion;
	}


	//Getters y Setters
	
	public String getCodEvaluacion() {
		return codEvaluacion;
	}

	public void setCodEvaluacion(String codEvaluacion) {
		this.codEvaluacion = codEvaluacion;
	}

	public String getDescEvaluacion() {
		return descEvaluacion;
	}

	public void setDescEvaluacion(String descEvaluacion) {
		this.descEvaluacion = descEvaluacion;
	}

	public void añadirNota(Nota nota) { 
        this.listaNotasEvaluacion.add(nota);
	}
	
	public List<Nota> getListaNotasEvaluacion() {
		return listaNotasEvaluacion;
	}

	public void setListaNotasEvaluacion(List<Nota> listaNotasEvaluacion) {
		this.listaNotasEvaluacion = listaNotasEvaluacion;
	}
	
	@Override
	public String toString() {
		return "\n\n--- Datos EvaluaciónDAO --- \ncod_evaluacion: " + codEvaluacion + "\ndesc_evaluacion: " + descEvaluacion;
	}
	
}
