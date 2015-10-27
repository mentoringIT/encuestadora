package com.mentoring.proyectos.escuesta.web.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentoring.proyectos.encuesta.dao.impl.UsuarioDAOImpl;
import com.mentoring.proyectos.encuesta.dao.interfaces.UsuarioDAO;
import com.mentoring.proyectos.encuesta.model.Usuario;

/**
 * Servlet implementation class UsuariosServlet
 */
public class UsuariosServlet extends HttpServlet {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		request.setAttribute("usuarios", usuarios);
		dispatcher = getServletContext().getRequestDispatcher("/vistas/usuarios.jsp");	
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
