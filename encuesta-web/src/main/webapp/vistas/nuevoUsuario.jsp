<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page isELIgnored="false"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Usuario</title>
</head>
<body>
<h2>Nuevo Usuario</h2>
<p><b>${requestScope.msj.descripcion}</b></p>
<form action="saveUsuario.do" method="post">

	Nombre Usuario: <input type="text" name="username"><br>
	Contraseña:<input type="password" name="password"><br>
	Admin: <input type="checkbox" name="isAdmin" value="true">
	<input type="submit" value="Guardar">
	
</form>
<a href="usuarios.do">Cancelar</a>
</body>
</html>