package com.ejemplo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.dao.Nota;

public interface NotasEvaluacionRepositorio extends JpaRepository<Nota, Integer> {
	
	/**
	 * Se encarga de recuperar todas las notas de evaluación de una determinado evaluación.
	 * @param codEvaluacion
	 * @return lista de notas por su evaluación
	 */
	 List<Nota> findByEvaluacion_CodEvaluacion(String codEvaluacion);

	/**
	 * Se encarga de recuperar todas las notas de evaluación de un determinado alumno.
	 * @param codAlumno id del alumno 
	 * @return lista de notas por su alumno
	 */
	 List<Nota> findByCodAlumno(String codAlumno);

}
