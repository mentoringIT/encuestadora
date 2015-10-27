package com.mentoring.proyectos.encuesta.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mentoring.proyectos.encuesta.dao.connection.ConnectionFactory;
import com.mentoring.proyectos.encuesta.dao.interfaces.UsuarioDAO;
import com.mentoring.proyectos.encuesta.model.Usuario;
import com.mentoring.proyectos.encuesta.model.catalogo.ResultadoUsuario;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection conexion;
	
	public ResultadoUsuario crearUsuario(String username, String password,
			boolean isAdmin) {
		ResultadoUsuario result = null;
		
		if(username.isEmpty() || password.isEmpty()){
			result = ResultadoUsuario.FALTA_DATO;
			return result;
		}
		
		String instert = "INSERT INTO usuario (username, password, admin) "
				+ "VALUES(?, ?, ?)"; 
		PreparedStatement statement;

		try {
			conexion = ConnectionFactory.getInstancia().getConnection();
			statement = conexion.prepareStatement(instert);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setBoolean(3, isAdmin);
			
			if(!statement.execute() && (statement.getUpdateCount() > 0)){
				result = ResultadoUsuario.OK;
			}
		} catch (MySQLIntegrityConstraintViolationException unique) {	
			result = ResultadoUsuario.USUARIO_EXISTE;
		} catch (Exception e) {
			result = ResultadoUsuario.OTRO_ERROR;
			e.printStackTrace();
		} finally {
			ConnectionFactory.getInstancia().closeConnection();
		}
		
		return result;
	}

	public Usuario obtenUsuario(String username, String password) {
		Usuario user = null;
		String select = "SELECT * FROM usuario "
				+ "WHERE username = ? "
				+ "AND password = ?";
		PreparedStatement statement;
		ResultSet resultSet;
		try {
			conexion = ConnectionFactory.getInstancia().getConnection();
			statement = conexion.prepareStatement(select);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				user = new Usuario();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setAdmin(resultSet.getBoolean("admin"));
			}
		} catch (SQLException e) {
			user = null;
			e.printStackTrace();
		} finally {
			ConnectionFactory.getInstancia().closeConnection();
		}
		return user;
	}

	public ResultadoUsuario actualizaUsuario(int id, String password, boolean isAdmin) {
		ResultadoUsuario result = null;
		PreparedStatement statement;
		String update = "UPDATE usuario SET password = ?, admin = ? WHERE id = ?";
		
		if(password.isEmpty()){
			return ResultadoUsuario.FALTA_DATO;
		}
		
		try {
			conexion = ConnectionFactory.getInstancia().getConnection();
			statement = conexion.prepareStatement(update);
			statement.setString(1, password);
			statement.setBoolean(2, isAdmin);
			statement.setInt(3, id);
			if(!statement.execute() && (statement.getUpdateCount() > 0)){
				result = ResultadoUsuario.ACTUALIZADO;
			}
		} catch (Exception e) {
			result = ResultadoUsuario.OTRO_ERROR;
		} finally {
			ConnectionFactory.getInstancia().closeConnection();
		}	
		return result;
	}

	public ResultadoUsuario eliminaUsuario(int id) {
		ResultadoUsuario result = null;
		PreparedStatement statement;
		String delete = "DELETE FROM usuario WHERE id = ?";
		
		try {
			conexion = ConnectionFactory.getInstancia().getConnection();
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, id);
			
			if(!statement.execute() && (statement.getUpdateCount() > 0)){
				result = ResultadoUsuario.ELIMINADO;
			}
			
		} catch (Exception ex) {
			result = ResultadoUsuario.OTRO_ERROR;
		} finally {
			ConnectionFactory.getInstancia().closeConnection();
		}
		
		return result;
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement statement;
		ResultSet resultSet;
		String list = "SELECT * FROM usuario";

		try {
			conexion = ConnectionFactory.getInstancia().getConnection();
			statement = conexion.prepareStatement(list);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				Usuario user = new Usuario();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setAdmin(resultSet.getBoolean("admin"));
				usuarios.add(user);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionFactory.getInstancia().closeConnection();
		}
		
		return usuarios;
	}
	
	public Usuario obtenUsuario(int id) {
		Usuario user = null;
		String select = "SELECT * FROM usuario WHERE id = ? ";
		PreparedStatement statement;
		ResultSet resultSet;
		try {
			conexion = ConnectionFactory.getInstancia().getConnection();
			statement = conexion.prepareStatement(select);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				user = new Usuario();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setAdmin(resultSet.getBoolean("admin"));
			}
		} catch (SQLException e) {
			user = null;
			e.printStackTrace();
		} finally {
			ConnectionFactory.getInstancia().closeConnection();
		}
		return user;
	}
	

}