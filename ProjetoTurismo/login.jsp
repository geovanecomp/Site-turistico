<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "head.jsp" %>
<body>
<%@ include file = "header.jsp" %>
<div id="wrapper">
	<div id="page-wrapper">
		<div id="page">
			<div id="wide-content">
				<div>
					<form action = 'LogarUsuarioController.do' method = 'post' name = 'login' id = 'login'>
						<table align = "center">
							<tr><td><h4><label>Login:</label></h4>
							<input type = 'text' size = '51' maxlength = '50' name = 'login' id = 'login' /><br/><br/></td></tr>
							<tr><td><h4><label>Senha:</label></h4>
							<input type = 'password' size ='51' maxlength = '50' name = 'senha' id ='senha' /><br/><br/></td></tr>
							<tr><td><center><input type = 'submit' class = "button-style" name ='logar' id = 'logar' value='Logar'/><br/></center></td></tr>
							<c:choose>
								<c:when test="${not empty status}">
									<tr><td><label><font color = 'red'>${status}</font></label></td></tr>
								</c:when>
							</c:choose>
						</table>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>