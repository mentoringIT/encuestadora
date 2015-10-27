package com.mentoring.proyectos.escuesta.web.usuario;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mentoring.proyectos.encuesta.dao.impl.UsuarioDAOImpl;
import com.mentoring.proyectos.encuesta.dao.interfaces.UsuarioDAO;
import com.mentoring.proyectos.encuesta.model.Usuario;

/**
 * Servlet implementation class EditarUsuarioServlet
 */
public class EditarUsuarioServlet extends HttpServlet {

	UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario user = usuarioDAO.obtenUsuario(id);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/vistas/editarUsuario.jsp");
		dispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
