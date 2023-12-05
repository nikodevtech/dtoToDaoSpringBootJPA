package com.ejemplo.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.dao.Evaluacion;
import com.ejemplo.dao.Nota;
import com.ejemplo.dto.EvaluacionDTO;
import com.ejemplo.dto.NotaDTO;
import com.ejemplo.repositorios.NotasEvaluacionRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz {@link NotasEvaluacionService} que proporciona
 * servicios relacionados con las notas de evaluación. Esta clase utiliza JPA
 * para interactuar con la capa de persistencia.
 * 
 * {@code @NotasEvaluacionRepositorio}: El Ioc de Spring inyecta un repositorio
 * para trabajar con la persistencia
 */
@Service
public class NotasEvaluacionServiceImpl implements NotasEvaluacionService {

	@Autowired
	private NotasEvaluacionRepositorio notasEvaluacionRepositorio;

	@Override
	@Transactional
	public void insertarNota(NotaDTO nota) {

		Nota notaDAO = new Nota();
		Evaluacion evaluacion = new Evaluacion();

		evaluacion.setCodEvaluacion(nota.getEvaluacion().getCodEvaluacion());
		evaluacion.setDescEvaluacion(nota.getEvaluacion().getDescEvaluacion());

		notaDAO.setEvaluacion(evaluacion);
		notaDAO.setCodAlumno(nota.getCodAlumno());
		notaDAO.setNotaEvaluacion(nota.getNotaEvaluacion());

		notasEvaluacionRepositorio.save(notaDAO);
	}

	@Override
	@Transactional
	public List<NotaDTO> buscarTodasLasNotas() {

		List<Nota> listaNotasDAO = notasEvaluacionRepositorio.findAll();

		List<NotaDTO> listaNotasDTO = new ArrayList<>();

		for (Nota n : listaNotasDAO) {

			EvaluacionDTO evalDTO = new EvaluacionDTO();
			evalDTO.setCodEvaluacion(n.getEvaluacion().getCodEvaluacion());
			evalDTO.setDescEvaluacion(n.getEvaluacion().getDescEvaluacion());
			listaNotasDTO.add(new NotaDTO(n.getCodAlumno(), n.getNotaEvaluacion(), evalDTO));
		}

		return listaNotasDTO;
	}

	@Override
	@Transactional
	public List<NotaDTO> buscarNotasPorCodAlumno(String codAlumno) {

		List<Nota> listaNotas = notasEvaluacionRepositorio.findByCodAlumno(codAlumno);
		List<NotaDTO> listaNotasDTO = new ArrayList<NotaDTO>();

		if (listaNotas != null) {

			for (Nota n : listaNotas) {
				EvaluacionDTO evalDTO = new EvaluacionDTO();
				evalDTO.setCodEvaluacion(n.getEvaluacion().getCodEvaluacion());
				evalDTO.setDescEvaluacion(n.getEvaluacion().getDescEvaluacion());
				listaNotasDTO.add(new NotaDTO(n.getCodAlumno(), n.getNotaEvaluacion(), evalDTO));
			}

		}

		return listaNotasDTO;
	}

	@Override
	@Transactional
	public void eliminarNota(int idNota) {

		Nota nota = notasEvaluacionRepositorio.findById(idNota).orElse(null);

		if (nota != null) {
			notasEvaluacionRepositorio.delete(nota);
		}
	}

	@Override
	@Transactional
	public void actualizarNota(NotaDTO nota) {

		Nota notaDAO = new Nota();
		Evaluacion evaluacion = new Evaluacion();

		evaluacion.setCodEvaluacion(nota.getEvaluacion().getCodEvaluacion());
		evaluacion.setDescEvaluacion(nota.getEvaluacion().getDescEvaluacion());

		notaDAO.setEvaluacion(evaluacion);
		notaDAO.setCodAlumno(nota.getCodAlumno());
		notaDAO.setNotaEvaluacion(nota.getNotaEvaluacion());

		notasEvaluacionRepositorio.save(notaDAO);

	}
	@Override
	@Transactional
	public List<NotaDTO> buscaNotasPorNotaDeEvaluacion(int nota) {
		
		List<Nota> listaNotas =notasEvaluacionRepositorio.buscaNotasPorNotaDeEvaluacion(nota);
		List<NotaDTO> listaNotasDTO = new ArrayList<>();
		for (Nota n : listaNotas) {
			EvaluacionDTO evalDTO = new EvaluacionDTO();
			evalDTO.setCodEvaluacion(n.getEvaluacion().getCodEvaluacion());
			evalDTO.setDescEvaluacion(n.getEvaluacion().getDescEvaluacion());
			listaNotasDTO.add(new NotaDTO(n.getCodAlumno(), n.getNotaEvaluacion(), evalDTO));
		}
		return listaNotasDTO;
	
	}



}
