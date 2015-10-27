<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<h2>Usuarios</h2>
	<p><b>${requestScope.msj.descripcion}</b></p>
	<table border="1">
		<thead>
			<tr>
				<th>UserName</th>
				<th>Admin</th>
				<th colspan="2">Opciones</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${requestScope.usuarios}" var="usuario">
				<tr>
					<td>${usuario.username}</td>
					<td>${usuario.admin == true ? 'Si' : 'No'}</td>
					<td><a href="editarUsuario.do?id=${usuario.id}">Editar</a></td>
					<td>Eliminar</td>
				</tr>			
			</c:forEach>
			
		</tbody>
		<tfoot>
			<tr>
				<td><a href="nuevoUsuario.do">Nuevo</a></td>
				<td colspan="3"></td>
			</tr>			
		</tfoot>
	</table>
	
	<p>
		Bienvenido <b>${sessionScope.usuario.username}</b> <a href="logout.do">Cerrar Sesion</a>
	</p>
</body>
</html>