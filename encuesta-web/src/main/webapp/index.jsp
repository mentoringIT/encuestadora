<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%>


<html>
<body>
	<h2>Sistema de Encuentas</h2>

	<c:choose>
		<c:when test="${sessionScope.usuario == null}">
			<p><b>${requestScope.msj.descripcion}</b></p>
		
			<form action="login.do" method="post">
				Nombre Usuario: <input type="text" name="username"><br>
				Contraseña:<input type="password" name="password"><br>
				<input type="submit" value="Iniciar Sesion">
			</form>
		</c:when>

		<c:otherwise>
			<p>
				Bienvenido ${sessionScope.usuario.username} 
				<a href="logout.do">Cerrar Sesion</a>
			</p>
			
		</c:otherwise>
	</c:choose>

</body>
</html>
