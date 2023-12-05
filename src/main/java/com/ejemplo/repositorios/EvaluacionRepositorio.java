package com.ejemplo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.dao.Evaluacion;

public interface EvaluacionRepositorio extends JpaRepository<Evaluacion, String> {

}
