package com.ejemplo.servicios;

import java.util.List;

import com.ejemplo.dao.Nota;
import com.ejemplo.dto.NotaDTO;

/**
 * Interfaz que declara los servicios relacionados con las notas de evaluación.
 * Proporciona métodos para insertar nuevas notas y buscar todas las notas existentes.
 */
public interface NotasEvaluacionService {
	
	/**
     * Inserta una nueva nota de evaluación en el sistema. Se convierte de DTO a DAO.
     *
     * @param nota La nota de evaluación a insertar.
     */
	public void insertarNota(NotaDTO nota);
	
	 /**
     * Recupera todas las notas de evaluación existentes en el sistema, se convierten todas las notas de DAO a DTO.
     *
     * @return Una lista de todas las notas de evaluación.
     */
	public List<NotaDTO> buscarTodasLasNotas();
	
	/**
	 * Se buscan todas las notas de un alumno por su codig, se convierten todas las notas de DAO a DTO.
	 * @param codAlumno el codigo del alumno
	 * @return Una lista de todas las notas de dicho alumno
	 */
    public List<NotaDTO> buscarNotasPorCodAlumno(String codAlumno) ;
  
    /**
     * Se modifica una nota previamente persistida en el sistema transformando de DTO a DAO
     * @param notaDTO la nota a modificar
     */
    public void actualizarNota(NotaDTO notaDTO); 
    
    
	/**
	 * Se elimina una nota previamente persistida en el sistema
	 * @param idNota el id de la nota que se va a eliminar
	 */
	public void eliminarNota(int idNota);
	
	/**
	 * Busca una nota de evaluación segun la nota dada
	 * @param nota por la que se filtra
	 * @return una lista de todas las notas
	 */
	public List<NotaDTO> buscaNotasPorNotaDeEvaluacion(int nota);
}
