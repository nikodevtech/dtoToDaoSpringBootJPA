package com.ejemplo.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.dao.Evaluacion;
import com.ejemplo.dao.Nota;
import com.ejemplo.dto.EvaluacionDTO;
import com.ejemplo.dto.NotaDTO;
import com.ejemplo.repositorios.EvaluacionRepositorio;

import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz {@link EvaluacionService} que proporciona
 * servicios relacionados con las evaluaciones Esta clase utiliza JPA para
 * interactuar con la capa de persistencia
 * 
 * {@code @NotasEvaluacionRepositorio}: El Ioc de Spring inyecta un repositorio para trabajar con la persistencia
 */
@Service
public class EvaluacionServiceImpl implements EvaluacionService {


	@Autowired
	private EvaluacionRepositorio evaluacionRepositorio;
	
	
	@Override
	@Transactional
	public void insertarEvaluacion(EvaluacionDTO evaluacionDTO) {
		
		//Convierte evaluacionDTO a una DAO
		Evaluacion evaluacionDAO = new Evaluacion();
		evaluacionDAO.setCodEvaluacion(evaluacionDTO.getCodEvaluacion());
		evaluacionDAO.setDescEvaluacion(evaluacionDTO.getDescEvaluacion());
		
		//También se convierten las notaDTO de la evaluacion a su respectivo DAO
		for(NotaDTO nota : evaluacionDTO.getListaNotasEvaluacion()) {
			
			Nota notaDAO = new Nota();
			notaDAO.setCodAlumno(nota.getCodAlumno());
			notaDAO.setNotaEvaluacion(nota.getNotaEvaluacion());
			notaDAO.setEvaluacion(evaluacionDAO);
			evaluacionDAO.añadirNota(notaDAO);
		}
		//Se persiste la evaluacion
		evaluacionRepositorio.save(evaluacionDAO);
	}

	@Override
	@Transactional
	public List<EvaluacionDTO> buscarTodasLasEvaluaciones() {
		
		//Obtiene todas las evaluaciones como DAO
		List<Evaluacion> evaluaciones = evaluacionRepositorio.findAll();
		List<EvaluacionDTO> evaluacionesDTO = new ArrayList<EvaluacionDTO>();
		
		//Se convierten las todas las evaluaciones DAO a evaluaciones DTO
		for(Evaluacion evaluacion : evaluaciones) {
			evaluacionesDTO.add(new EvaluacionDTO(evaluacion.getCodEvaluacion(), evaluacion.getDescEvaluacion()));
		}
		
		//Se devuelven todas las evaluaciones como DTO
		return evaluacionesDTO;
	}

	@Override
	@Transactional
	public EvaluacionDTO buscarEvaluacionPorId(String codEvaluacion) {
		
		//Obtiene la evaluacion como DAO por su ID
		Evaluacion evaluacion = evaluacionRepositorio.findById(codEvaluacion).orElse(null);
		if (evaluacion == null) {
			return null;
		}
		
		//Si la evaluacion existe, se convierte la evaluacion DAO a evaluacion DTO
		EvaluacionDTO evaluacionDTO = new EvaluacionDTO();
		evaluacionDTO.setCodEvaluacion(evaluacion.getCodEvaluacion());
		evaluacionDTO.setDescEvaluacion(evaluacion.getDescEvaluacion());
		
		//Se devuelven la evaluacion como DTO
		return evaluacionDTO;
	}

	@Override
	@Transactional
	public void actualizarEvaluacion(EvaluacionDTO evaluacion) {
		
		//Se convierten las evaluaciones DTO a evaluaciones DAO
		Evaluacion evaluacionDAO = new Evaluacion();		
		evaluacionDAO.setCodEvaluacion(evaluacion.getCodEvaluacion());
		evaluacionDAO.setDescEvaluacion(evaluacion.getDescEvaluacion());
		
		//Se persiste la evaluacion
		evaluacionRepositorio.save(evaluacionDAO);
	}

	@Override
	@Transactional
	public void eliminarEvaluacion(String codEvaluacion) {
		Evaluacion evaluacion = evaluacionRepositorio.findById(codEvaluacion).orElse(null);
		if (evaluacion != null) {
			evaluacionRepositorio.delete(evaluacion);
		}
	}
	

}
