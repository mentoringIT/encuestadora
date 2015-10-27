package com.mentoring.proyectos.encuesta.dao.interfaces;

import java.util.List;

import com.mentoring.proyectos.encuesta.model.Opcion;

public interface OpcionDAO {

	boolean creaOpcion(String opcion, int valor, int idPregunta);
	
	Opcion obtenOpcion(int id);
	
	boolean actualizaOpcion(int id, String opcion, int valor);
	
	boolean eliminaOpcion(int id);
	
	List<Opcion> listarOpciones(int idPregunta);
	
}