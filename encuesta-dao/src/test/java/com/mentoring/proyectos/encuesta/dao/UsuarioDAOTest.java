package com.mentoring.proyectos.encuesta.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

import com.mentoring.proyectos.encuesta.dao.impl.UsuarioDAOImpl;
import com.mentoring.proyectos.encuesta.dao.interfaces.UsuarioDAO;
import com.mentoring.proyectos.encuesta.model.Usuario;
import com.mentoring.proyectos.encuesta.model.catalogo.ResultadoUsuario;

public class UsuarioDAOTest {

	private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
	private String username = "userTest";
	private String password = "passTest";
	private String nuevoPass = "nuevoPass";
	
	@Test
	public void crearTest(){
		boolean isAdmin = true;
		ResultadoUsuario result = 
			usuarioDAO.crearUsuario(username, password, isAdmin);
		Assert.assertTrue(result == ResultadoUsuario.OK);
	}
	
	@Test
	public void listarTest(){
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		Assert.assertNotNull(usuarios);
		System.out.println(usuarios.toString());
		Assert.assertFalse(usuarios.isEmpty());		
	}
	
	@Test
	public void actualizaTest(){
		Usuario user = usuarioDAO.obtenUsuario(username, password);
		Assert.assertNotNull(user);
		System.out.println("Antes: " + user.toString());
		
		user.setPassword(nuevoPass);
		user.setAdmin(!user.isAdmin());
		//ejecuta update y compreba el resultado
		ResultadoUsuario result = 
			usuarioDAO.actualizaUsuario
				(user.getId(), user.getPassword(), user.isAdmin());
		Assert.assertTrue(result == ResultadoUsuario.ACTUALIZADO);
		//recuperamos el usuario con el nuevo password y comprobamos
		user = usuarioDAO.obtenUsuario(username, user.getPassword());
		Assert.assertNotNull(user);
		System.out.println("Despues: " + user.toString());
		//intentamos recuperar el usuario con los datos anteriores 
		//comprobamos que no existe
		user = usuarioDAO.obtenUsuario(username, password);
		Assert.assertNull(user);
	}
	
	@Test
	public void eliminarTest(){		
		Usuario user = usuarioDAO.obtenUsuario(username, nuevoPass);
		Assert.assertNotNull(user);
		ResultadoUsuario result = 
				usuarioDAO.eliminaUsuario(user.getId());	
		Assert.assertEquals(result, ResultadoUsuario.ELIMINADO);
		user = usuarioDAO.obtenUsuario(username, password);
		Assert.assertNull(user);
	}
	
}
