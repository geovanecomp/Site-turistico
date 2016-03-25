<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<center><h2>Minhas Informações</h2></center>
					<table align = 'center'>
					<c:choose>
						<c:when test="${usuarioSessao.login eq (usuario.login)}">
								<center><h4><label>Login: ${usuario.login}</label></h4><br /></center>
						</c:when>
					</c:choose>
						<tr><td><h4><label>Nome: ${usuario.nome}</label></h4><br /></td><td></td>
						<td><h4><label>Email: ${usuario.email}</label></h4><br /></td><td></td>
						<td><h4><label>Sexo: ${usuario.sexo}</label></h4><br /></td><td></td></tr>
						<tr><td><h4><label>Nascimento: <fmt:formatDate value="${usuario.nascimento}" pattern="dd/MM/yyyy"/></label></h4><br /></td><td></td>
						<td><h4><label>Cidade: ${usuario.cidade}</label></h4><br /></td><td></td>
						<td><h4><label>Estado: ${usuario.estado}</label></h4><br /></td><td></td></tr>
						<tr><td><h4><label>Profissão: ${usuario.profissao}</label></h4><br /></td><td></td>
						<td><h4><label>Estado Civil: ${usuario.estadoCivil}</label></h4><br /></td><td></td>
						<td><h4><label>Escolaridade: ${usuario.escolaridade}</label></h4><br /></td><td></td></tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>