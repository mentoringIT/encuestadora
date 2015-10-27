package com.mentoring.proyectos.encuesta.dao.interfaces;

import java.util.List;

import com.mentoring.proyectos.encuesta.model.Pregunta;

public interface PreguntaDAO {

	boolean crearPregunta(String pregunta, int idEncuesta);
	
	Pregunta obtenPregunta(int id);
	
	boolean actualizaPregunta(int id, String pregunta);
	
	boolean eliminaPregunta(int id);
	
	List<Pregunta> listarPreguntas(int idEncuesta);
	
}