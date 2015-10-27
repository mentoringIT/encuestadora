package com.mentoring.proyectos.encuesta.dao;

import java.sql.Connection;

import org.junit.Test;

import junit.framework.Assert;

import com.mentoring.proyectos.encuesta.dao.connection.ConnectionFactory;

public class ConnectionFactoryTest {

//	@Test
	public void testFactory(){
		ConnectionFactory connection, conn2;
		connection = ConnectionFactory.getInstancia();
		conn2 = ConnectionFactory.getInstancia();
		
		Assert.assertNotNull(connection);
		Assert.assertTrue(connection instanceof ConnectionFactory);
		
		Assert.assertNotNull(conn2);
		Assert.assertTrue(conn2 instanceof ConnectionFactory);
		
		Assert.assertEquals(connection, conn2);
	}
	
//	@Test
	public void testConexion(){
		ConnectionFactory factory;
		Connection conexion;
		
		factory = ConnectionFactory.getInstancia();
		
		conexion = factory.getConnection();
		Assert.assertNotNull(conexion);
		Assert.assertTrue(conexion instanceof Connection);
		factory.closeConnection();
	}
	
}
