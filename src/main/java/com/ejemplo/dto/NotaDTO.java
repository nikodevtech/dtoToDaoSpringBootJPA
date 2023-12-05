package com.ejemplo.dto;

/**
 * Clase DTO que representa una nota de evaluación.
 */
public class NotaDTO {
	
	private int idNota;
    private String codAlumno;
    private int notaEvaluacion;
    private EvaluacionDTO evaluacion;


    public NotaDTO() {
	    
    }
    public NotaDTO( String codAlumno, int notaEvaluacion, EvaluacionDTO evaluacion) {
	    this.codAlumno = codAlumno;
	    this.notaEvaluacion = notaEvaluacion;
	    this.evaluacion = evaluacion;
    }
	public String getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}
	public int getNotaEvaluacion() {
		return notaEvaluacion;
	}
	public void setNotaEvaluacion(int notaEvaluacion) {
		this.notaEvaluacion = notaEvaluacion;
	}
	public EvaluacionDTO getEvaluacion() {
		return evaluacion;
	}
	public void setEvaluacion(EvaluacionDTO evaluacion) {
		this.evaluacion = evaluacion;
	}
	
	public int getIdNota() {
		return idNota;
	}
	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}
	@Override
	public String toString() {
		return "NotaDTO [codAlumno=" + codAlumno + ", notaEvaluacion=" + notaEvaluacion + ", evaluacion=" + evaluacion
				+ "]";
	}
    
    

}
