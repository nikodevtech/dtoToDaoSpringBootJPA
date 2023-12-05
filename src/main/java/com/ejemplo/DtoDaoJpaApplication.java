package com.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ejemplo.controladores.EvaluacionController;
import com.ejemplo.controladores.NotasEvaluacionController;
import com.ejemplo.dao.Nota;
import com.ejemplo.dto.EvaluacionDTO;
import com.ejemplo.dto.NotaDTO;

@SpringBootApplication
public class DtoDaoJpaApplication {

	public static void main(String[] args) {
		//Levantamos el contexto de la aplicación
		ApplicationContext contexto = SpringApplication.run(DtoDaoJpaApplication.class, args);
		
		//El contenedor de spring nos dispensa a los controladores
		EvaluacionController controladorEv = contexto.getBean(EvaluacionController.class);
	    NotasEvaluacionController controladorNt = contexto.getBean(NotasEvaluacionController.class);
	    
	    // Creamos y persistimos evaluaciones
        EvaluacionDTO evaluacion1 = new EvaluacionDTO("PR", "Primera Evaluación");
        EvaluacionDTO evaluacion2 = new EvaluacionDTO("SG", "Segunda Evaluación");
        EvaluacionDTO evaluacion3 = new EvaluacionDTO("TC", "Tercera Evaluación");
        controladorEv.insertarEvaluacion(evaluacion1);
        controladorEv.insertarEvaluacion(evaluacion2);
        controladorEv.insertarEvaluacion(evaluacion3);

        // Crear notas de alumnos asociadas a las evaluaciones
        NotaDTO notaEv1alumno1 = new NotaDTO("alumno1", 10, evaluacion1);
        NotaDTO notaEv2alumno1 = new NotaDTO("alumno1", 7, evaluacion1);
        NotaDTO notaEv3alumno1 = new NotaDTO("alumno1", 7, evaluacion1);

//        // Establecer la relación bidireccional
        evaluacion1.registrarNota(notaEv1alumno1);
        evaluacion2.registrarNota(notaEv2alumno1);
        evaluacion3.registrarNota(notaEv3alumno1);
        

//        // Persistir las notas de evaluación
        controladorNt.insertarNota(notaEv1alumno1);
        controladorNt.insertarNota(notaEv2alumno1);
        controladorNt.insertarNota(notaEv3alumno1);
        

//        //PRUEBAS CONSOLA
//        // Select all
//        System.out.println(
//                "**** Listado de evaluaciones ****\n" + controladorEv.buscarTodasLasEvaluaciones());
//        System.out.println(
//                "**** Listado de Notas ****\n" + controladorNt.buscarTodasLasNotas());
//
//        System.out.println(pruebaNota.toString());
//
//        // Select by id
//        System.out.println(controladorEv.buscarEvaluacionPorId("TC").toString());
//
//        // Update
//        Evaluacion pruebaEvaluacion = controladorEv.buscarEvaluacionPorId("TC");
//        pruebaEvaluacion.setDescEvaluacion("Update Evaluacion");
//        controladorEv.actualizarEvaluacion(pruebaEvaluacion);
//        System.out.println(controladorEv.buscarEvaluacionPorId("TC").toString());
//
//        // Delete
//        Evaluacion evaluacionBorrar = new Evaluacion("remove", "Prueba Borrado");
//        controladorEv.insertarEvaluacion(evaluacionBorrar);
//        controladorEv.eliminarEvaluacion("remove");
       
//		  for(NotaDTO nt : controladorNt.buscarNotasPorCodAlumno("alumno1")) {
//	      	 System.out.println(nt.toString());
//		  }
//        
	}

}
