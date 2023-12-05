package com.ejemplo.dao;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * Clase DAO que representa la entidad NotasEvaluacion en el sistema.
 * Esta clase se utiliza para almacenar información sobre las notas que tienen los alumnos en las evaluaciones.
 * La información se persiste en la base de datos mediante JPA.
 */
@Entity
@Table(name = "eva_tch_notas_evaluacion", schema = "sc_evaluacion")
public class Nota {

	//Atributos
	
    @Id
    @Column(name = "id_nota_evaluacion", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotaEvaluacion;

    @Column(name = "md_uuid")
    private String mdUuid;

    @Column(name = "md_fch")
    private Date mdFch;

    @Column(name = "cod_alumno", nullable = false)
    private String codAlumno;

    @Column(name = "nota_evaluacion", nullable = false)
    private int notaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "cod_evaluacion")
    private Evaluacion evaluacion;

    
    //Constructores
    
    public Nota() {
    }
    
    public Nota( String codAlumno, int notaEvaluacion, Evaluacion evaluacion) {
		this.codAlumno = codAlumno;
		this.notaEvaluacion = notaEvaluacion;
		this.evaluacion = evaluacion;
    }

    //Getters y Setters
    
    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getMdUuid() {
        return mdUuid;
    }

    public void setMdUuid(String mdUuid) {
        this.mdUuid = mdUuid;
    }

    public int getIdNotaEvaluacion() {
        return idNotaEvaluacion;
    }

    public void setIdNotaEvaluacion(int idNotaEvaluacion) {
        this.idNotaEvaluacion = idNotaEvaluacion;
    }

    public Date getMdFch() {
        return mdFch;
    }

    public void setMdFch(Date mdFch) {
        this.mdFch = mdFch;
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

    @Override
    public String toString() {
        return "\n\n--- Datos NotasDAO ---\nmdUuid: " + mdUuid + "\nmdFch:" + mdFch + "\nidNotaEvaluacion:"
                + idNotaEvaluacion + "\ncodAlumno:" + codAlumno + "\nnotaEvaluacion:" + notaEvaluacion
                + "\nEvaluacion:" + evaluacion.getCodEvaluacion();
    }
}
