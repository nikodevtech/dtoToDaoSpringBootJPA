package com.ejemplo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DTO que representa una evaluación.
 */
public class EvaluacionDTO {
	
	private String codEvaluacion;
	private String descEvaluacion;
	private List<NotaDTO> listaNotasEvaluacion = new ArrayList<NotaDTO>();
	
	
	public EvaluacionDTO() {
		super();
	}
	public EvaluacionDTO(String codEvaluacion, String descEvaluacion) {
		super();
		this.codEvaluacion = codEvaluacion;
		this.descEvaluacion = descEvaluacion;
	}
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
	
	public List<NotaDTO> getListaNotasEvaluacion() {
		return listaNotasEvaluacion;
	}
	
	public void setListaNotasEvaluacion(List<NotaDTO> listaNotasEvaluacion) {
		this.listaNotasEvaluacion = listaNotasEvaluacion;
	}
	
	public void registrarNota(NotaDTO nota){
		listaNotasEvaluacion.add(nota);
	}
	
	
	@Override
	public String toString() {
		return "EvaluacionDTO [codEvaluacion=" + codEvaluacion + ", descEvaluacion=" + descEvaluacion + "]";
	}
	
	

	

}
