package com.mentoring.proyectos.escuesta.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mentoring.proyectos.encuesta.dao.impl.UsuarioDAOImpl;
import com.mentoring.proyectos.encuesta.dao.interfaces.UsuarioDAO;
import com.mentoring.proyectos.encuesta.model.Usuario;
import com.mentoring.proyectos.encuesta.model.catalogo.ResultadoUsuario;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario user;
		HttpSession sesion;
		RequestDispatcher dispatcher;
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		dispatcher = 
				getServletContext().getRequestDispatcher("/index.jsp");
		// Valida si algun dato esta vacio
		if(userName.isEmpty() || password.isEmpty()){
			request.setAttribute("msj", ResultadoUsuario.FALTA_DATO);
		} else {
			//intenta recuperar el usuario
			user = usuarioDAO.obtenUsuario(userName, password);
			if(user != null) {
				//crea la sesion y agrega al usuario
				sesion = request.getSession(true);
				sesion.setAttribute("usuario", user);
				//si el usuario es administrador lo manda al jsp de usuarios
				if(user.isAdmin()){
					response.sendRedirect("usuarios.do");
					return;
				}			
			} else {
				//muestra el mensaje de que el usuario no se encontro
				request.setAttribute("msj", ResultadoUsuario.NO_EXISTE);
			}
		}		
		dispatcher.forward(request, response);
	}

}
