<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <c:choose>
		<c:when test="${not empty status}">
			<font color = 'red'>${status}</font>
		</c:when>
	</c:choose>
	<form action = 'BuscarAtrativoPeloDistritoController.do' method = 'post' name = 'buscarAtrativoPeloDistrito' id = 'buscarAtrativoPeloDistrito'>
		<table>
			<tr><td><label>Distrito:</label></td></tr>
			<tr><td><input type = 'text' name = 'distrito' id = 'distrito'/></td></tr>
			<tr><td><input type = 'submit' name = 'buscarAtrativoPeloDistrito' id = 'buscarAtrativoPeloDistrito' value = 'Buscar'/></td></tr>
		</table>
	</form>
</body>
</html>