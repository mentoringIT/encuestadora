package com.mentoring.proyectos.encuesta.dao.interfaces;

import java.util.List;

import com.mentoring.proyectos.encuesta.model.Usuario;
import com.mentoring.proyectos.encuesta.model.catalogo.ResultadoUsuario;

public interface UsuarioDAO {

	ResultadoUsuario crearUsuario(String username, String password, boolean isAdmin);
	
	Usuario obtenUsuario(String username, String password);
	
	ResultadoUsuario actualizaUsuario(int id, String password, boolean isAdmin);
	
	ResultadoUsuario eliminaUsuario(int id);
	
	List<Usuario> listarUsuarios();
	
	Usuario obtenUsuario(int id);
	
}