package com.ejemplo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ejemplo.dao.Nota;
import com.ejemplo.dto.NotaDTO;
import com.ejemplo.servicios.NotasEvaluacionService;

/**
 * Controlador que gestiona las operaciones relacionadas con las notas de los alumnos
 * Utiliza el servicio {@link NotasEvaluacionService} para interactuar con la capa da servicio de persistencia a NotasEvaluacion
 *
 * Las operaciones marcadas como {@code @Transactional} indican que deben ejecutarse dentro de una transacción,
 * gestionada por el IoC de Spring
 */
@Controller
public class NotasEvaluacionController {

	@Autowired
	private NotasEvaluacionService notasEvaluacionService;
	
	public void insertarNota(NotaDTO nota) {
		notasEvaluacionService.insertarNota(nota);
	}
	
	public List<NotaDTO> buscarTodasLasNotas() {
		return notasEvaluacionService.buscarTodasLasNotas();
	}
	
    public List<NotaDTO> buscarNotasPorCodAlumno(String codAlumno){
    	return notasEvaluacionService.buscarNotasPorCodAlumno(codAlumno);
    }

}
