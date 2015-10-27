package com.mentoring.proyectos.encuesta.dao.interfaces;

import java.util.List;

import com.mentoring.proyectos.encuesta.model.Encuesta;

public interface EncuestaDAO {

	boolean crearEncuesta(String titulo);
	
	Encuesta obtenEncuesta(int id);
	
	boolean actualizaEncuesta(int id, String titulo);
	
	boolean eliminaEncuesta(int id);
	
	List<Encuesta> listarEncuestas();
	
}