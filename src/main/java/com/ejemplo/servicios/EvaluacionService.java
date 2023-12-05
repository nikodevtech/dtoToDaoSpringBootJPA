package com.ejemplo.servicios;

import java.util.List;

import com.ejemplo.dao.Evaluacion;
import com.ejemplo.dto.EvaluacionDTO;

/**
 * Interfaz que declara los servicios relacionados con las evaluaciones.
 * Proporciona métodos para insertar nuevas evaluaciones y buscar todas las evaluaciones existentes.
 */
public interface EvaluacionService  {

	/**
     * Inserta una nueva evaluación en el sistema, se pasa de DTO a DAO.
     *
     * @param evaluacion La evaluación a insertar.
     */
	public void insertarEvaluacion(EvaluacionDTO evaluacion);
	
	 /**
     * Recupera todas las evaluaciones existentes en el sistema, se cambia DAO a DTO.
     *
     * @return Una lista de todas las evaluaciones.
     */
	public List<EvaluacionDTO> buscarTodasLasEvaluaciones();
	
	/**
	 * Busca  una evaluación por su id previamente persistida en el sistema, se camba de DAO a DTO.
	 * 
	 * @param su id que es el codigo de la evaluación 
	 * @return la evaluación
	 */
	public EvaluacionDTO buscarEvaluacionPorId(String codEvaluacion);
	
	/**
	 * Modifica una evaluación previamente persistida en el sistema tras pasar de DTO a DAO.
	 * @param evaluacion modificada
	 */
	public void actualizarEvaluacion(EvaluacionDTO evaluacion);
	
	/**
	 * Elimina una evaluación previamente persistida en el sistema
	 * @param codEvaluacion que se va a eliminar
	 */
	public void eliminarEvaluacion(String codEvaluacion);
	
	

	
}
