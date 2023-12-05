package com.ejemplo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ejemplo.dao.Evaluacion;
import com.ejemplo.dto.EvaluacionDTO;
import com.ejemplo.servicios.EvaluacionService;

/**
 * Controlador que gestiona las operaciones relacionadas con las evaluaciones en la capa de presentación
 * Utiliza el servicio {@link EvaluacionService} para interactuar con la capa da servicio de persistencia a Evaluacion
 *
 * Las operaciones marcadas como {@code @Transactional} indican que deben ejecutarse dentro de una transacción,
 * gestionada por el IoC de Spring
 */
@Controller
public class EvaluacionController {

	@Autowired
	private EvaluacionService evaluacionService;
	
	public void insertarEvaluacion(EvaluacionDTO evaluacion) {
		evaluacionService.insertarEvaluacion(evaluacion);
	}
	
	public List<EvaluacionDTO> buscarTodasLasEvaluaciones() {
		return evaluacionService.buscarTodasLasEvaluaciones();
	}
	
	public EvaluacionDTO buscarEvaluacionPorId(String codEvaluacion) {
		return evaluacionService.buscarEvaluacionPorId(codEvaluacion);
	}
	
	public void actualizarEvaluacion(EvaluacionDTO evaluacion) {
		evaluacionService.actualizarEvaluacion(evaluacion);
	}
	
	public void eliminarEvaluacion(String codEvaluacion) {
		evaluacionService.eliminarEvaluacion(codEvaluacion);
	}
}
