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
import com.mentoring.proyectos.encuesta.model.catalogo.ResultadoUsuario;

/**
 * Servlet implementation class GuardaUsuarioServlet
 */
public class GuardaUsuarioServlet extends HttpServlet {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		ResultadoUsuario resultado;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isAdmin = Boolean.valueOf(request.getParameter("isAdmin"));
		if(request.getParameter("id") != null){ //Si viene el id entonces la peticion viene de editar
			int id = Integer.parseInt(request.getParameter("id"));
			ResultadoUsuario update = usuarioDAO.actualizaUsuario(id, password, isAdmin);
			request.setAttribute("msj", update);
			if(update == ResultadoUsuario.ACTUALIZADO){
				response.sendRedirect("usuarios.do");
				return;
			} else {
				Usuario user = usuarioDAO.obtenUsuario(id);
				request.setAttribute("user", user);
				dispatcher = 
						getServletContext().getRequestDispatcher("/vistas/editarUsuario.jsp");
				dispatcher.forward(request, response);
			}
			
		} else { //si no viene id la peticion viene de nuevo
			resultado = usuarioDAO.crearUsuario(userName, password, isAdmin);		
			request.setAttribute("msj", resultado);
			
			if (resultado == ResultadoUsuario.OK) {
				response.sendRedirect("usuarios.do");
				return;
			} else {
				dispatcher = 
						getServletContext().getRequestDispatcher("/vistas/nuevoUsuario.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
