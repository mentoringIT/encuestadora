package com.mentoring.proyectos.encuesta.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private String host;
	
	private String user;
	
	private String password;
	
	private Connection conexion;
	
	private static ConnectionFactory instancia;
	
	private ConnectionFactory(){
		host = "jdbc:mysql://127.0.0.1:3306/encuestadora";
		user = "root";
		password = "";		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstancia(){
		if(instancia == null) {
			instancia = new ConnectionFactory();
		}
		return instancia;
	}
	
	public Connection getConnection(){
		try {
			conexion = DriverManager.getConnection(host, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
	
	public void closeConnection(){
		if(conexion != null){
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
	
}